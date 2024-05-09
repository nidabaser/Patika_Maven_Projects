Bu bölümde HQL (Hibernate Query Language) komutlarına odaklanacağız.
JPA'da kullandığımız JPQL mantığının, Hibernate tarafından nasıl uyarlandığını inceleyeceğiz.
Burada, JPQL'de nasıl uyguladığımızı zaten biliyorduk,
ancak Hibernate'ın kendi sorgu yapısını HQL ile nasıl kullanabileceğimizi öğreneceğiz.

HQL sorgularını öğrenmek, JPQL ile benzer bir yapıya sahip olduğu için zaman kaybetmemize gerek olmayan bir konudur.
HQL sorgularını JPQL'den farklı kılan birkaç özellik vardır ve bunları kısa bir şekilde özetleyerek size sunmayı hedefliyoruz.

Örneğin, basit bir HQL sorgusu şu şekildedir: "from Customer".
Burada, "from" kelimesinden sonra gelen "Customer" ifadesi, veritabanındaki "customer" tablosundaki tüm verileri listeler.
Bu, JPQL'deki mantıkla aynıdır.

Eğer bir koşul eklemek istersek, örneğin, "Select * from Customer where id = 2" gibi,
HQL'de bunu "from Customer where id = 2" şeklinde yazabiliriz.
Parametreli sorgular da JPQL'deki gibi kullanılır ve bu parametreler, set edilecek metotlar içinde belirtilir.

Sorgularımızı daha da özelleştirmek için "order by" veya "group by" gibi SQL kavramlarını HQL içinde kullanabiliriz.
Ayrıca, "join" işlemlerini de gerçekleştirebiliriz.
Join işlemleri, entity sınıfları üzerinde yapıldığı için, JPQL ile aynı mantığı takip eder.

HQL'de subquery'ler kullanmak da mümkündür.
"Select * from Entity where id = (subquery)" şeklinde alt sorgular ekleyebilir ve
bu şekilde verileri daha spesifik bir şekilde çekebiliriz.

Ayrıca, HQL'de limit ve offset kullanımı, SQL'deki gibi,
sorgu sonuçlarını sınırlamak veya belirli bir konumdan başlamak için mümkündür.

Bu örnekler, HQL'in JPQL ile benzerlik gösterdiğini ve temel sorgu yapılarının birbirine paralel olduğunu göstermektedir.
HQL öğrenmek, Hibernate kullanıcıları için ek avantajlar sağlar ve daha etkili sorgular yazmalarına olanak tanır.
Bu temel konuları anladığımızda, ilerleyen derslerde Spring üzerinde nasıl kullanılabileceğini de göreceğiz.

Bu bölümde HQL komutlarını inceledik.
Bir sonraki seviyelere geçmek için JP ve Hibernate bölümlerini tamamladığımızda daha ileri konulara geçiş yapabileceğiz. Görüşmek üzere.