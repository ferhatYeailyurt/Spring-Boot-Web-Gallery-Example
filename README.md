Projemizde gönderilen dokümanda yol izlenerek uygulamalar yapıldı. İlk aşamada data first yaklaşımı benimsendi daha sonra code first yardımı ile varlıkları ve bu varlıklar arasındaki ilişkiler uygulandı.Veri tabanı teknolojisi olarak PostgreSql 9.4 kullanılmıştır. Web uygulamasını MAVEN projesi üzerine build edilmiştir. Geliştirme ortamı Eclipse Neon 3 IDE kullanıldı. View kısmı için JSP kullanıldı. Bootstrap ile ilk önce tasarlandı ve test edildi.Projeyi kendi çalışma ortamında çalışmak isterseniz "springboot\src\main\resources\application.properties" database bilgilerini ayarlamanız gerekmektedir.Projemizin çalışma aşamaları,
Projemizde 3 adet view mevcuttur.
1.bunlardan ilki anasayfadır , kullanıcıyı "hış geldiniz" yazısı ile karşılamaktadır.
2.Resim ekleme sayfası, bu sayfada eklenecek resimin bilgisi database, resim datası ise farklı bir kaynağa kayıt edilmiştir.
3.Eklenmiş olan tüm kayıtların listelenmesi ise tüm resimlerin gerekli bilgileri getirilerek alanlar doldurulmuştur.
4.Resimlere tıklandığında ise tam sayfada eklenmiş olan resim gösterilmiştir.



Ferhat Yeşilyurt