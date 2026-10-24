# Aurelia Roastery

## Proje Hakkında

**Proje adı:** Aurelia Roastery
**Takım adı:** Aurelia

**Kısa açıklama:**
Bir kafenin menü, masa ve sipariş işlemlerini tek bir masaüstü uygulaması üzerinden yönetmek için geliştirilmektedir. Sistem; Admin, Garson ve Mutfak/Barista rollerine göre farklı işlemler sunar. Menü ve masa bilgileri yönetilebilir, masalara sipariş oluşturulabilir ve siparişlerin hazırlık durumu takip edilebilir. Veriler bir veritabanı yerine özel uzantılı metin dosyalarında saklanır; uygulama açılırken ilgili veri yapılarına yüklenir ve kaydetme sırasında güncel hâli dosyalara yazılır.

## Ekip

| Üye                           | GitHub kullanıcı adı | Sorumlu olduğu alan                               |
| ------------------------------ | ----------------------- | -------------------------------------------------- |
| Mert Ömer Ezer (Proje Lideri) | mertomerezer            | Proje kapsamı, JavaFX arayüzü ve masa yönetimi |
| Halil Keleş                   | keleshalil              | Menü/ürün yönetimi ve dosya yükleme/kaydetme  |
| Emir Sadri Geçgil             | emirsadri               | Sipariş yönetimi ve Mutfak/Barista akışı      |
| Musa Tekin                     | Musatekn                | Kullanıcı girişi ve rol izinleri                |

## Kullanılan Teknolojiler

- Programlama dili: Java
- Masaüstü arayüzü: JavaFX
- Veri saklama: Özel uzantılı metin dosyaları

## Temel İşlevler

- Kullanıcı girişi ve role göre izin kontrolü
- Menü ve ürün yönetimi: ürün ekleme, silme, güncelleme, listeleme, sorgulama ve sıralama
- Masa yönetimi: masa bilgileri yönetilir; masa durumu sipariş açılınca dolu, sipariş kapanınca boş olarak otomatik değişir
- Sipariş yönetimi: masaya sipariş oluşturma, sipariş bilgilerini yönetme, siparişleri masa numarası veya durumuna göre sorgulama ve oluşturulma zamanına göre sıralama
- Mutfak/Barista akışı: siparişleri görme ve hazırlık durumlarını güncelleme
- Verileri açılışta dosyadan yükleme ve Kaydet işlemiyle güncel verilerin tamamını dosyaya yazma

## Roller

| Rol            | Görevler                                                                                                                                                                                                   |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Admin          | Menü ürünlerini ekler, siler ve günceller; masa bilgilerini yönetir; masa durumu sipariş açılınca dolu, sipariş kapanınca boş olarak otomatik değişir; tüm siparişleri görüntüleyebilir. |
| Garson         | Masaları ve menüyü görüntüler; masa seçerek sipariş oluşturur; siparişe ürün ve miktar ekler; kendi siparişlerinin durumunu takip eder ve gerektiğinde düzeltir veya iptal eder.             |
| Mutfak/Barista | Hazırlanacak siparişleri görüntüler; siparişleri “Hazırlanıyor” ve “Hazır” olarak günceller; menü, masa ve kullanıcı ayarlarını değiştiremez.                                          |

## Kullanılacak Veri Yapıları

| Modül / işlev                    | Veri yapısı türü | Tutulan veri | Desteklemesi gereken işlemler | Tercih nedeni | Sorumlu |
| ---------------------------------- | -------------------- | ------------ | ------------------------------ | ------------- | ------- |
| Menü / ürün yönetimi           |                      |              |                                |               |         |
| Masa yönetimi                     |                      |              |                                |               |         |
| Sipariş kayıtları               |                      |              |                                |               |         |
| Mutfak / Barista sipariş sırası |                      |              |                                |               |         |
| Kullanıcı / rol yönetimi        |                      |              |                                |               |         |

## Temel Sınıf ve Düğüm Taslağı

| Kullanıldığı veri yapısı | Düğüm sınıfı | Düğümün tuttuğu veri | Bağlantı alanları | Ana yapıda tutulacak referanslar |
| ------------------------------ | ------------------ | ------------------------- | -------------------- | --------------------------------- |
|                                |                    |                           |                      |                                   |
|                                |                    |                           |                      |                                   |


## Dosyadan Yükleme ve Kaydetme

Uygulama açılırken özel uzantılı metin dosyalarındaki kayıtlar ilgili veri yapılarına yüklenir. Ekleme, silme, güncelleme, sorgulama ve sıralama işlemleri veri yapıları üzerinde yapılır. Kullanıcı Kaydet işlemini seçtiğinde güncel veriler topluca ilgili dosyalara yeniden yazılır.

## Proje Klasör Yapısı

```text
Cafe Management System/
├── backend/
│   └── src/
│       ├── model/       # Ürün, masa, sipariş ve kullanıcı modelleri
│       ├── structures/  # Ekip tarafından geliştirilen veri yapıları
│       ├── service/     # Uygulama iş kuralları ve işlemleri
│       ├── persistence/ # Metin dosyalarından yükleme ve dosyaya kaydetme
│       └── auth/        # Giriş ve rol izinleri
├── frontend/
│   └── src/
│       ├── app/         # JavaFX uygulamasının başlangıcı
│       ├── screens/     # JavaFX ekranları
│       └── controllers/ # Ekran etkileşimleri
└── data/                # Uygulamanın veri dosyaları
```
