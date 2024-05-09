package dev.nida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nida Başer
 * April 2024
 */

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // Code ekleme
//        Code code = new Code();
//        code.setGroup("121113");
//        code.setSerial("444556");
//        entityManager.persist(code);
//
        // Ürün ekleme
//        Product product = new Product();
//        product.setName("IPhone 15 Pro");
//        product.setPrice(12345);
//        product.setCode(code);
//        entityManager.persist(product);
//
//        System.out.println(code);
//        System.out.println(product.toString());

        // ONE TO ONE
//        Product product = entityManager.find(Product.class,1);
//        System.out.println(product.toString());
//
//        Code code = entityManager.find(Code.class,1);
//        System.out.println(code.getProduct().getName());

//        // ONE TO MANY
//        Supplier supplier = new Supplier();
//        supplier.setAddress("Address");
//        supplier.setCompany("Patika");
//        supplier.setContact("555 888 6677");
//        supplier.setMail("nida@patika.dev");
//        supplier.setPerson("Nida");
//        entityManager.persist(supplier);
//
//        // Code ekleme
//        Code code = new Code();
//        code.setGroup("121113");
//        code.setSerial("444556");
//        entityManager.persist(code);
//
//        //Ürün ekleme
//        Product product = new Product();
//        product.setName("IPhone 15 Pro");
//        product.setPrice(12345);
//        product.setStock(100);
//        product.setSupplier(supplier);
//        product.setCode(code);
//        entityManager.persist(product);
//
//        System.out.println(product.toString());

        // Aşağıdaki kod ToString metodu yüzünden sonsuz döngüye girer. DİKKAT !!!
//        Product product = entityManager.find(Product.class,1);
//        System.out.println(product.toString()); // Product toString metodu Supplier'ın toString metodunu çağırır,
        // sonra o da tekrar product'taki toString metodunu çağırır, böyle sonsuz döngü olur
        // Birinden birinin toString metodu içinden silinmesi lazım yani

//        Supplier supplier = entityManager.find(Supplier.class, 1);
//        //Code ekleme
//        Code code = new Code();
//        code.setGroup("123123");
//        code.setSerial("456456");
//        entityManager.persist(code);
//        //Ürün ekleme
//        Product product = new Product();
//        product.setName("Samsung Galaxy M23");
//        product.setPrice(7500);
//        product.setStock(5);
//        product.setCode(code);
//        product.setSupplier(supplier);
//        entityManager.persist(product);
//
//        System.out.println(product.toString());

//        Supplier supplier = entityManager.find(Supplier.class, 1);
//        for (Product product : supplier.getProductList()){
//            System.out.println(product.toString());
//        }

        // MANY TO ONE

        /*
        // Supplier Ekleme
        Supplier supplier = new Supplier();
        supplier.setAddress("Address");
        supplier.setCompany("Patika");
        supplier.setContact("555 888 66 44");
        supplier.setMail("nida@patika.dev");
        supplier.setPerson("Nida Baser");
        entityManager.persist(supplier);

        // Code Ekleme
        Code code = new Code();
        code.setGroup("123123");
        code.setSerial("456456");
        entityManager.persist(code);

        // Category Ekleme
        Category category = new Category();
        category.setName("Mobile Phones");
        entityManager.persist(category);

        //Ürün ekleme
        Product product = new Product();
        product.setName("Samsung Galaxy M23");
        product.setPrice(7500);
        product.setStock(5);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);
        entityManager.persist(product);

        System.out.println(product.toString());
         */

        // Color ekleme
        /*
        Color blue = new Color("Blue");
        Color red = new Color("Red");
        Color green = new Color("Green");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(green);

        Product product = entityManager.find(Product.class, 1);
        List<Color> colorList = new ArrayList<>(); // product.getColorList();
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);

        entityManager.persist(product);
        */

        // Ekrana yazdırma da iki farklı tablo üzerinden gerçekleştirilebilir (ister product ister color)
        //Product product = entityManager.find(Product.class, 1);
        //System.out.println(product.getColorList().toString());

//        Color color = entityManager.find(Color.class,1);
//        System.out.println(color.getProductList().toString());

        // FETCH LAZY denemeleri
        //System.out.println(product.getName());
        //System.out.println(product.getCategory().getName());

        // CASCADE
//        Code code = new Code();
//        code.setSerial("1234321");
//        code.setGroup("54321");
//
//        Product product = new Product();
//        product.setName("Test");
//        product.setStock(11);
//        product.setPrice(123);
//        product.setCategory(entityManager.find(Category.class, 1));
//        product.setSupplier(entityManager.find(Supplier.class, 1));
//        product.setCode(code);
//
//        entityManager.persist(product);

        Product product = entityManager.find(Product.class, 2);
        //System.out.println(product.getCode().toString());

        // Yani aşağıda CODE üzerinden de güncelleyebilirsin demiş olduk
//        product.getCode().setGroup("12345");
//        product.setName("Update Test");
//        entityManager.merge(product);

        // REMOVE
        //entityManager.remove(product); // Bu da cascade ile ilişkili tablolardaki verileri de ilgili ürünle birlikte siler.

        transaction.commit();

        // Cascade PERSIST seçilmişti sonuç olarak biz code için persist yapmadan sadece product için persist yaparak code'unda persist'ini sağladık:
        //Hibernate: insert into codes (code_group,code_serial) values (?,?) returning code_id
        //Hibernate: insert into products (product_category_id,product_code_id,product_name,product_price,product_stock,product_supplier_id) values (?,?,?,?,?,?) returning product_id

        // PEKİ CASCADE PERSIST YERINE REMOVE İLİŞKİSİ VERİRSEK NASIL OLUR:
        // CODE'UN EKLENMEDİĞİNİ GÖRÜRÜZ VE PRODUCT IN CODE ID'SI BOŞ OLUNCA HATA ALIRIZ




        // CRUD - Create, Read, Update, Delete
//        transaction.begin(); // Transaction Begin ve Commit'i eklemezsek veritabanı değişmiyor DİKKAT !!!
//        Customer customer = entityManager.find(Customer.class, 1);
//        System.out.println(customer.toString());
//
//        customer.setName("Nethra Furina");
//        entityManager.persist(customer);
//
//        // Update için merge komutu
//        Customer customerToUpdate = entityManager.find(Customer.class, 1);
//        customerToUpdate.setName("UpdatedName");
//        entityManager.merge(customerToUpdate);
//
//        // Delete için remove komutu
//        entityManager.remove(customer);

//        transaction.commit(); // En sona bu Commit metodunu eklemeyi unutma !!





//        // Mesela bu ayrı bir transaction olduğundan bunu ekler
//        transaction.begin();
//        Customer c1 = new Customer();
//        c1.setName("Sena");
//        c1.setMail("sena@patika.dev");
//        c1.setGender(Customer.GENDER.FEMALE);
//        c1.setOnDate(LocalDate.now());
//        entityManager.persist(c1);
//        transaction.commit();
//
//        // Ama bu transaction için hata verir, unique mail olmadığından
//        transaction.begin();
//        Customer customer = new Customer();
//        customer.setName("Nida");
//        customer.setMail("nida@patika.dev");
//        customer.setGender(Customer.GENDER.FEMALE);
//        customer.setOnDate(LocalDate.now());
//        entityManager.persist(customer);
//        transaction.commit();
//
//        // Eğer iki ayrı transaction'ı tek bir transaction içinde yaparsak,
//        // rollback olup ilk transaction doğru olsa bile ikincisi yanlış olduğundan
//        // hiçbir veri veritabanına eklenmez, ACID:Ya hep ya hiç mantığı

    }
}