Bu yazıda, katmanlı mimari kullanarak bir Hibernate projesi oluşturmayı ve temel veri tabanı işlemlerini gerçekleştirmeyi öğreneceğiz.
Projemizde Hibernate'i kullanarak veri tabanı işlemlerini yöneteceğiz.

1. Proje Oluşturma ve Bağımlılıkların Eklenmesi:

İlk olarak, projemizi oluşturduk ve gerekli bağımlılıkları ekledik.
Projemizi Hibernate ile entegre etmek için hibernate.cfg.xml dosyasını oluşturduk ve konfigürasyon ayarlarımızı gerçekleştirdik.

2. Veritabanı Bağlantısı ve Konfigürasyon:

Hibernate'in veritabanına bağlanabilmesi için hibernate.cfg.xml dosyasında gerekli ayarları yaptık.
Bu ayarlar arasında veritabanı URL'si, kullanıcı adı, şifre, sürücü tipi gibi bilgiler bulunmaktadır.

3. Entity Sınıfının Oluşturulması:

Projemizdeki veritabanı tablosunu temsil edecek olan entity sınıfını oluşturduk.
Bu örnekte Customer adında bir entity sınıfı kullandık.

4. Hibernate Session Yönetimi:

Hibernate'in session yönetimini sağlamak üzere HibernateUtil adında bir yardımcı sınıf oluşturduk.
Bu sınıf, Hibernate Session Factory'nin oluşturulması ve session alınması işlemlerini gerçekleştirir.
Aynı zamanda bu sınıfı Singleton tasarım deseni ile implemente ettik.

5. Dao (Data Access Object) Katmanının Oluşturulması:

Veritabanı işlemlerini gerçekleştiren Dao katmanını oluşturduk.
Bu katman, entity sınıfımızla ilgili temel CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirir.
Dao katmanı, Business katmanına veri tabanı işlemlerini soyutlamak için kullanılır.

6. Business Katmanının Oluşturulması:

Veri tabanı işlemlerinin yönetildiği katman olan Business katmanını oluşturduk.
Bu katman, kullanıcıdan gelen verileri kontrol eder, işlemleri yönlendirir ve
gerektiğinde veri tabanı işlemlerini gerçekleştirmek üzere Dao katmanını kullanır.

7. Exception Handling:

Business katmanında hata kontrolü yaparak, veri tabanına eklenecek olan kayıtların benzersiz olduğunu kontrol ettik.
Eğer aynı kayıt varsa, kullanıcıya bilgi verip işlemi gerçekleştirmedik.

8. Uygulama Testi:

Oluşturduğumuz işlemleri test etmek adına bir main sınıf oluşturduk.
Bu sınıf üzerinden, örnek bir müşteri ekledik, güncelledik, sildik ve
ID bazlı bir müşteri sorgulama işlemi gerçekleştirdik.

Bu şekilde, katmanlı mimari kullanarak Hibernate ile nasıl bir proje oluşturulacağını ve
temel veri tabanı işlemlerinin nasıl gerçekleştirileceğini öğrenmiş olduk.