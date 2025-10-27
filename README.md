# 🌦️ HavaDurumu Uygulaması

**HavaDurumu**, OpenWeatherMap API’sini kullanarak şehir bazlı anlık hava durumu bilgisini alan
ve bu verileri PostgreSQL veritabanına kaydeden bir **Java konsol uygulamasıdır.**

---

## 🚀 Başlangıç

### Gereksinimler

- Java 8 veya üzeri  
- Eclipse IDE veya IntelliJ IDEA  
- PostgreSQL veritabanı  
- İnternet bağlantısı (OpenWeatherMap API erişimi için)

---

## ⚙️ Kurulum

1. Bu projeyi klonlayın:
   ```bash
   git clone https://github.com/kullaniciadi/HavaDurumu.git
   ```

2. Projeyi tercih ettiğiniz Java IDE’sinde açın.

3. OpenWeatherMap sitesinden bir **API anahtarı** alın:  
   🔗 [https://openweathermap.org/api](https://openweathermap.org/api)

4. `ApiClient.java` dosyasındaki anahtar kısmını kendi anahtarınızla değiştirin:
   ```java
   private static final String API_KEY = "SENIN_API_KEYIN";
   ```

5. PostgreSQL üzerinde veritabanını oluşturun:
   ```sql
   CREATE DATABASE weatherdb;
   ```

6. Ardından aşağıdaki tabloyu oluşturun:
   ```sql
   CREATE TABLE weather_history (
       id SERIAL PRIMARY KEY,
       city VARCHAR(50),
       temperature DECIMAL(5,2),
       description VARCHAR(100),
       query_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```

7. `Database.java` içindeki bağlantı bilgilerini kendi veritabanınıza göre düzenleyin:
   ```java
   private static final String URL = "jdbc:postgresql://localhost:5432/weatherdb";
   private static final String USER = "postgres";
   private static final String PASS = "123456";
   ```

8. Projeyi çalıştırın 🚀  
   - Uygulama sizden şehir adını ister.  
   - API’den hava durumu bilgisi çeker.  
   - Ekrana sonuçları yazar ve veritabanına kaydeder.

---

## 💻 Örnek Kullanım

```bash
Şehir adı giriniz: Istanbul
Şehir: Istanbul
Sıcaklık: 18.5 °C
Durum: clear sky
Veri veritabanına kaydedildi ✅
```

---

## 🗄️ Veritabanı Yapısı

| Alan Adı     | Türü          | Açıklama                |
|---------------|----------------|-------------------------|
| id            | SERIAL (PK)    | Otomatik kimlik alanı  |
| city          | VARCHAR(50)    | Şehir adı              |
| temperature   | DECIMAL(5,2)   | Sıcaklık (°C)          |
| description   | VARCHAR(100)   | Hava durumu açıklaması |
| query_time    | TIMESTAMP      | Sorgulama zamanı        |

---

## 📦 Proje Dosyaları

```
com.weatherapp/
│
├── ApiClient.java    # OpenWeatherMap API bağlantısı
├── Database.java     # PostgreSQL kayıt işlemleri
├── Weather.java      # Model sınıfı (city, temperature, description)
└── Main.java         # Konsol uygulaması (kullanıcı girişi ve akış)
```

---

## ⚙️ Kullanılan Teknolojiler

- ☕ **Java 8+**  
- 🗄️ **PostgreSQL**  
- 🔗 **OpenWeatherMap API**  
- 🧩 **JDBC**

---

## 📝 Lisans

Bu proje açık kaynaklıdır.  
