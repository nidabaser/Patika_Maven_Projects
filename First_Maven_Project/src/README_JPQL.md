Bu bölümde Java dilinde kullanılan JPQL yani Java Persistence Query Language (Java Kalıcılık Sorgu Dili) üzerine odaklanacağız. JPQL, artık SQL yazmadan kendi sınıflarımız üzerinden veritabanı sorguları yapmamıza olanak tanır.

JPQL'nin Temel Amacı:

JPQL, veritabanı tablo ve sütun isimleri yerine Java sınıf ve özellik isimlerine dayanan sorgular yazmamızı sağlar. Örneğin, SQL ile "SELECT * FROM categories" sorgusunu JPQL'de "SELECT category FROM Category category" şeklinde yazabiliriz.

JPQL Sorguları:

````java
// Tüm ürünleri çekme örneği
TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
List<Product> productList = query.getResultList();

// ID'si 1 olan kategoriyi çekme örneği
TypedQuery<Category> categoryQuery = entityManager.createQuery("SELECT c FROM Category c WHERE c.id = 1", Category.class);
Category singleCategory = categoryQuery.getSingleResult();

//JPQL ve Parametre Kullanımı:

// Belirli bir fiyattan düşük olan ürünleri çekme örneği
TypedQuery<Product> priceQuery = entityManager.createQuery("SELECT p FROM Product p WHERE p.price < :maxPrice", Product.class);
priceQuery.setParameter("maxPrice", 100.0);
List<Product> affordableProducts = priceQuery.getResultList();
````

Yukarıdaki örneklerde görüldüğü gibi, JPQL, Java kodlarına benzer bir syntax ile sorguların yazılmasına imkan tanır. Bu, veritabanı işlemlerini daha Java geliştiricisi dostu hale getirir.

JPQL ile Veri Çekme ve Sorgulama

DTO (Data Transfer Object) Oluşturma

Veritabanından çekilen verilerin sınıflar aracılığıyla taşınması için DTO'lar oluşturulmaktadır. Özellikle, ORM (Object-Relational Mapping) işlemlerinde, veritabanındaki tablolara karşılık gelen sınıflar oluşturularak bu sınıflar üzerinden veri transferi gerçekleştirilmektedir.

````java
public class ChipProduct {
private Long id;

private String prodName;
private Double prodPrice;

// Getter and Setter methods
}
````

2. JPQL ile Veri Çekme

Videoda, JPQL sorguları kullanarak veritabanından veri çekme işlemleri gösterilmektedir. Aşağıda, örneğin devamı bulunmaktadır:

````java
// Veritabanından ürün sayısını çekme
TypedQuery<Long> countQuery = entityManager.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
Long productCount = countQuery.getSingleResult();

// Veritabanından en yüksek fiyatlı ürünü çekme
TypedQuery<Product> maxPriceQuery = entityManager.createQuery(
"SELECT p FROM Product p ORDER BY p.price DESC", Product.class);
maxPriceQuery.setMaxResults(1);
Product maxPricedProduct = maxPriceQuery.getSingleResult();

// Kategori bazında ürün sayılarını listeleyebilme
TypedQuery<Object[]> categoryProductCountQuery = entityManager.createQuery(
"SELECT c.name, COUNT(p) FROM Product p JOIN p.category c GROUP BY c.name", Object[].class);
List<Object[]> categoryProductCountList = categoryProductCountQuery.getResultList();

// Like sorgusu ile belirli bir örneğe uyan ürünleri çekme
TypedQuery<Product> likeQuery = entityManager.createQuery(
"SELECT p FROM Product p WHERE p.name LIKE 'BR%'", Product.class);
List<Product> likeResultList = likeQuery.getResultList();
````

3. NamedQuery Kullanımı

Ayrıca, videoda JPQL sorgularını daha yönetilebilir hale getirmek için @NamedQuery özelliğinden bahsedilmektedir. Bu özellik sayesinde sıkça kullanılan sorguları bir kez tanımlayarak, bu isimle çağırılabilir hale getirebiliriz.

````java
@Entity
@NamedQuery(name = "Product.findCheapProducts", query = "SELECT p FROM Product p WHERE p.price < :price")
public class Product {
// ...
}
````

Daha sonra bu sorgu şu şekilde çağrılabilir:

````java
TypedQuery<Product> cheapProductsQuery = entityManager.createNamedQuery("Product.findCheapProducts", Product.class);
cheapProductsQuery.setParameter("price", 20.0);
List<Product> cheapProducts = cheapProductsQuery.getResultList();
````

Bu adımlar, JPQL'nin temel kullanımını ve sorgulama işlemlerini anlatan örnekler içermektedir. Bu bilgileri kullanarak, veritabanı işlemlerini daha etkili ve sürdürülebilir bir şekilde gerçekleştirebilirsiniz.