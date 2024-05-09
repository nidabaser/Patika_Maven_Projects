Hibernate üzerinden veritabanı işlemlerini sessionlar aracılığıyla yönetebiliriz. Bu konuda Hibernate, JPA (Java Persistence API) uyguladığı için veritabanıyla olan sınıf nesne ilişkilerimizi entity sınıfları aracılığıyla yapıyoruz. Önceki bölümde oluşturduğumuz "Customer" entity sınıfını projemize dahil ettik.

Hibernate kullanımında, temel işlemler genellikle session ve transaction kullanarak gerçekleştirilir. Örneğin, bir transaction başlatmak için "session.beginTransaction()" kullanılır. Daha sonra, işlemler başarılı bir şekilde gerçekleşirse "transaction.commit()" yapılır, hata durumunda ise "transaction.rollback()" ile geri alınır. Son olarak, "session.close()" ile session kapatılır.

Aşağıda, temel bir işlem adımı sırasını içeren bir örnek bulunmaktadır:

````java
try {
  // Session başlatma ve transaction başlatma
  Session session = sessionFactory.openSession();
  Transaction transaction = session.beginTransaction();

  // Veritabanı işlemleri burada gerçekleştirilir

  // Transaction'ı commit etme
  transaction.commit();
} catch (Exception e) {
  // Hata durumunda transaction'ı geri al ve exception yazdır
  if (transaction != null) {
    transaction.rollback();
  }
  e.printStackTrace();
} finally {
  // Session'ı kapat
  if (session != null) {
    session.close();
  }
}
````

Bu örnekte, veritabanı işlemleri try bloğu içinde gerçekleştirilmekte ve bir hata durumunda catch bloğu içinde işlemler geri alınmaktadır. Son olarak, finally bloğunda ise session kapatılmaktadır.

Entity sınıflarını Hibernate'e tanıtmak için, configure kısmında "ADD annotated Class" ile ilgili sınıfların belirtilmesi gerekir. Bu örnekte, "Customer" entity sınıfını eklemek için "ADD annotated Class Customer" ifadesini kullanmıştır.

Ayrıca, veritabanına kayıt eklemek, güncellemek veya silmek için "session.persist()", "session.update()" ve "session.remove()" gibi yöntemler kullanılır. Örneğin:

````java
Customer customer = new Customer();
customer.setName("Test");
customer.setGender(Customer.GENDER.FEMALE);
customer.setCreationDate(LocalDate.now());
customer.setMail("test@patika.dev");

try {
  Session session = sessionFactory.openSession();
  Transaction transaction = session.beginTransaction();

  // Veritabanına kayıt ekleme
  session.persist(customer);

  // Transaction'ı commit etme
  transaction.commit();
} catch (Exception e) {
  // Hata durumunda transaction'ı geri al ve exception yazdır
  if (transaction != null) {
    transaction.rollback();
  }
  e.printStackTrace();
} finally {
  // Session'ı kapat
  if (session != null) {
    session.close();
  }
}
````

Bu örnekte, yeni bir "Customer" nesnesi oluşturulmuş ve veritabanına eklenmiştir.

Hibernate Query Language (HQL) ile veritabanından veri çekmek için "session.createQuery()" kullanılır. Örneğin:
````java
List<Customer> customers = session.createSelectionQuery("FROM Customer", Customer.class).getResultList();
````

Bu ifade ile tüm müşteri verilerini liste olarak çekebilirsiniz. Ayrıca, tek bir kayıt çekmek için "getSingleResult()" kullanılabilir ve olmayan bir kayıt durumunda "NoResultException" alınabilir.

Bu temel bilgiler doğrultusunda Hibernate'in veritabanı işlemlerini yönetme sürecini anlamış olduk. İlerleyen bölümlerde daha fazla detay ve örnek göreceğiz. 