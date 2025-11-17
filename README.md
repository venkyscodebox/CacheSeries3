# CacheSeries3

A Spring Boot 3.x sample project demonstrating caching of MongoDB-backed user data using Redis.  
It shows how to use `@Cacheable` with Redis, and how to switch to JSON serialization for cached values.

---

## 🧩 Features

- Spring Boot 3.x REST API for user retrieval  
- MongoDB persistence for `User` entities  
- Redis caching of user lookup results via `@Cacheable`  
- Configurable serialization of cache values (JSON instead of Java binary)  
- Demonstration of cache hit vs. cache miss mechanism  
- Clean layering: Controller → Service → Repository  
- Use of Spring Data MongoDB and Spring Data Redis  

---

## 📂 Project Structure

src/
main/
java/org/main/cacheseries/
entity/ — User + Role classes
repo/ — MongoRepository interface
service/ — Business logic with caching
controller/ — REST endpoints
config/ — Redis cache configuration
application.yml — configuration properties
pom.xml — project dependencies



---

## 🚀 Getting Started

### Prerequisites

- Java 17+ (compatible with Spring Boot 3.x)  
- Maven (or use the included `mvnw`)  
- A running MongoDB instance  
- A running Redis instance  

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/venkyscodebox/CacheSeries3.git
   cd CacheSeries3
2.Configure your application.yml (or application.properties) with the proper MongoDB and Redis connection details.

3.Start the application:

./mvnw spring-boot:run

4.Use a REST client (e.g., Postman, curl) to test the API:
GET http://localhost:8080/main/getuser/{email}

- First call with a given email: service method executes, user loaded from MongoDB and cached in Redis.

- Subsequent calls: user retrieved from Redis cache (method should not execute again).

🧠 How the Caching Works
The UserService.findByEmail(...) method is annotated with:
@Cacheable(value = "users", key = "#email")

- This means results of this method are stored in the Redis cache named users.
- By  default, Spring’s Redis cache uses Java serialization (binary blobs). To avoid issues like java.io.InvalidClassException, we configure the cache to use JSON serialization instead.
- The custom RedisConfig class sets:
  - StringRedisSerializer for keys
  - GenericJackson2JsonRedisSerializer (with Jackson) for values
  - Enables storing of values as JSON, making them readable and version-tolerant

##Why Use JSON Serialization
- JSON is human-readable (you can inspect cached values in Redis easily)
- Avoids issues when class versions change (e.g., missing serialVersionUID or class structure changes)
- Interoperable if you later switch languages or clients

##Dependencies
- Key dependencies (in pom.xml):
- spring-boot-starter-data-mongodb
- spring-boot-starter-data-redis
- spring-boot-starter-web
- lombok
- jakarta.validation (for entity validation)

#Thank you for checking out CacheSeries3. Happy caching! 🚀
