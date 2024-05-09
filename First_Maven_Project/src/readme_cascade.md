# Cascade (Kaskad) Nedir?

JPA ve Hibernate, ilişkisel veritabanlarında yapılan işlemleri yönetmek için kullanılan önemli araçlardır. "Cascade" veya Türkçe adıyla "Kaskad", ilişkilendirilmiş (bağlantılı) tablolar üzerinde yapılan bir işlemin, diğer tablolara otomatik olarak yansıtılmasını sağlayan bir özelliktir.

Cascade Türleri

Persist (Kalıcı Hale Getirme):

İki tablo arasındaki ilişkide bir nesne persist (kalıcı hale getirildiğinde) işlemi gerçekleştirildiğinde, bu durum diğer tabloya da yansır. Yani, ilişkili tabloya yeni bir kayıt eklenmiş olur.

@OneToOne(mappedBy = "product", cascade = CascadeType.PERSIST)

Merge:

İki tablo arasındaki ilişkide bir nesne merge (birleştirme) işlemi gerçekleştirildiğinde, bu değişiklik diğer tabloya da otomatik olarak yansır.

@OneToOne(mappedBy = "product", cascade = CascadeType.MERGE)
Remove (Silme):

Bir tablo üzerinde silme işlemi yapıldığında, bu durum ilişkilendirilmiş diğer tablolara da yansır. Silinen ana kayıta ait diğer kayıtlar da silinir.

@OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE)

All (Tüm İşlemler):

Cascade tipi "ALL" olarak belirlendiğinde, persist, merge, remove gibi tüm işlemler otomatik olarak kaskatı şekilde gerçekleştirilir.

@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
Cascade Kullanımı Örnek:

Örneğin, "Product" ve "Code" adlı iki tablomuz var. "Product" tablosu ile "Code" tablosu arasında "one to one" ilişkisi bulunmaktadır.

@Entity
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
private Code code;

// Diğer alanlar, getter ve setter metotları
}

@Entity
public class Code {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@OneToOne
@JoinColumn(name = "product_id")
private Product product;

// Diğer alanlar, getter ve setter metotları
}
Yukarıdaki örnekte, "cascade = CascadeType.ALL" ifadesiyle ilişkili tablolardaki tüm işlemlerin otomatik olarak gerçekleştirilmesi sağlanmıştır.