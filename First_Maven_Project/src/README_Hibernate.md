Hibernate'e giriş yaparak bu popüler ORM (Object-Relational Mapping) aracının temel özelliklerini anlamaya çalışacağız.
Ancak, konuya başlamadan önce, daha önce ele aldığımız Java Persistence API (JPA) hakkında kısa bir özet geçiş yapalım.

### Java Persistence API (JPA) Nedir?

JPA, Java Enterprise Edition'ın bir standardıdır ve Java tabanlı projelerde veritabanı ile etkileşimde bulunmak için kullanılan bir API'dir.
JPA'nın temel amacı, Java kodlarıyla veritabanlarını yönetmeyi kolaylaştırmaktır.
Bu sayede, projelerimizi daha düzenli ve bakımı kolay hale getirebiliriz.

JPA, Object-Relational Mapping (ORM) prensiplerine dayanır.
ORM, programlamada nesneleri ve veritabanını ilişkilendirerek, bu ilişkiyi kodlarla yönetmemizi sağlayan bir tekniktir.
JPA, bu ORM yapısını uygulayan bir standarttır ve farklı ORM araçlarının aynı standartları kullanabilmesini sağlar.

### Hibernate Nedir?

Hibernate, JPA standardını uygulayan ve aynı zamanda bu standarda ek özellikler sunan bir ORM aracıdır.
Hibernate, JPA'nın sunduğu temel özelliklere ek olarak, daha fazla esneklik ve performans avantajları sunan popüler bir çözümdür.

Hibernate'in avantajları arasında, özellikle karmaşık veritabanı sorgularının daha iyi performansla çalıştırılabilmesi ve
SQL performans sorunlarına karşı çeşitli çözümler sunabilmesi ön plandadır. N+1 problemi gibi tipik ORM performans sorunlarına karşı içsel çözümleri vardır.

### Hibernate'in Esnekliği ve Performans Avantajları

Hibernate, kendi özellikleri ve yapılarıyla JPA'nın sunduğu standartları genişletir.
Bu sayede, projelerimizde daha fazla esneklik sağlayarak, özel gereksinimlere daha iyi cevap verebiliriz.
Aynı zamanda, performans konusunda da öne çıkan çeşitli optimizasyonlar ve çözümler içerir.

Bu yüzden, Hibernate'i tercih etmek, projelerimizde JPA'nın standartlarını kullanarak aynı zamanda ek avantajlar elde etmemizi sağlar.

### Sonuç ve Bir Sonraki Adım

Bu bölümde, Hibernate'in ne olduğunu ve JPA'dan nasıl farklılaştığını anlamaya çalıştık.
Bir sonraki bölümde, bu teorik bilgileri uygulamaya dökerek Hibernate projemizi nasıl kuracağımızı ve
temel kodlama konularına nasıl giriş yapabileceğimizi öğreneceğiz.

--------------------------------------------------------------------------------------------------------

Bu bölümde, Hibernate'in nasıl kurulduğunu adım adım inceleyeceğiz. Hibernate'i projemize eklemek için Maven projesi kullanacağız. İlk olarak, Hibernate'i projemize eklemek için Maven dependency'lerini tanımlamamız gerekiyor.

````java
<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-core</artifactId>
  <version>6.3.0.Final</version>
</dependency>

<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>42.6.0</version>
</dependency>
````

Bu dependency'leri ekleyerek, Hibernate ve PostgreSQL sürücüsünü projemize dahil ediyoruz.
Ardından, bu bağımlılıkları projemize yüklemek için Maven'ın reload özelliğini kullanabiliriz.

Şimdi, Hibernate'in temel yapısını kullanabilmemiz için bir configuration dosyasına ihtiyacımız var.
Bu dosyayı "hibernate.cfg.xml" adında bir dosya olarak resources klasörü içerisine ekleyeceğiz.
Bu dosya, Hibernate'in çalışma şeklini ve veritabanı bağlantı ayarlarını içerir.

````java
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>

  <session-factory>
    <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
    <property name="hibernate.connection.url">jdbc:postgresql://localhost:5433/test</property>
    <property name="hibernate.connection.username">postgres</property>
    <property name="hibernate.connection.password">1234</property>
    <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
    <property name="hibernate.hbm2ddl.auto">create-drop</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.format_sql">true</property>
  </session-factory>

</hibernate-configuration>
````

Bu konfigürasyon dosyasında, PostgreSQL bağlantı bilgilerimizi, Hibernate'in SQL sorgularını gösterip göstermeyeceğini, SQL formatlamasını ve tabloların oluşturulma şeklini belirliyoruz.

Şimdi, Hibernate Session Factory'yi oluşturmak ve bir Session başlatmak için Java koduna geçebiliriz.

````java
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

public static void main(String[] args) {

    // Hibernate Configuration
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");

    // Build Hibernate Session Factory
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    // Open a session
    try (Session session = sessionFactory.openSession()) {
      // Hibernate operations go here
    } catch (Exception e) {
      e.printStackTrace();
    }
}
}
````

Burada, Hibernate Configuration'ı oluşturuyoruz ve daha sonra bu konfigürasyonu kullanarak bir Session Factory inşa ediyoruz. Son olarak, bir Hibernate Session açarak veritabanı işlemlerimizi gerçekleştirebiliriz.

Bu adımlarla, Hibernate'i projemize ekleyip temel bir yapıyı oluşturduk. Daha sonraki bölümlerde, Hibernate ile veritabanı işlemlerini nasıl gerçekleştirebileceğimizi detaylı bir şekilde inceleyeceğiz. 