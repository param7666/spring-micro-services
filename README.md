# Spring Microservices Collection

A collection of small Spring Boot microservice demo projects showcasing core microservices concepts: Eureka discovery servers, Config servers, Producer/Consumer services, Admin server, and example business services like Billing, Booking, Vehicle/Customer services and more.

> **Repository structure (top-level folders)**

This repository contains multiple demo projects organized as separate folders. Key folders include:

* `BootMSProj01-EurekaServer` — Simple Eureka discovery server.
* `BootMSProj02-WishMessageMS` — Example service that returns a greeting/wish message.
* `BootMSProj03-TestingService` — Simple testing/demo service.
* `BootMSProj04-BillingService` — Billing service demo (provider/consumer variations present elsewhere).
* `BootMSProj04-ShopingMs-ConsumerApp` — Shopping consumer application example.
* `BootMSProj05-Student-EurekaServer` — Eureka server for student-library demos.
* `BootMSProj05-Student-LibraryService-ProviderApp` — Provider service for Student-Library demo.
* `BootMSProj05-Student-LibraryService-ConsumerApp` — Consumer app for Student-Library demo.
* `BootMSProj06-*` — Several projects showing ShoppingService, BillingService provider/consumer, and Eureka servers.
* `BootMSProj07-*` — Config Server (native), EurekaServer, and ShoppingService examples.
* `BootMSProj08-*` and `BootMSProj09-*` — A larger example set (VSMS: Vehicle/Booking/Customer services), Config, Eureka and Admin server demos.

> **Note:** There are many more sub-projects under the `BootMSProjXX-*` folders — each is a self-contained Spring Boot application for learning and experimentation.

---

## What you'll learn

* How to register microservices with a Eureka discovery server.
* How to create simple Config Server (native) and load configuration for clients.
* Producer/Consumer patterns between microservices.
* Building multiple small Spring Boot applications and running them together.
* Using Spring Boot Admin (present in some folders) for monitoring.

---

## Prerequisites

* Java (JDK 17 or later recommended)
* Maven 3.6+
* Git
* (Optional) Docker if you want to containerize the services

---

## How to run a demo project locally

Each project is a standalone Spring Boot app. Typical steps to run any demo:

1. Open a terminal and navigate to the project folder, for example:

```bash
cd BootMSProj01-EurekaServer
```

2. Build and run with Maven:

```bash
mvn clean package
# or directly run
mvn spring-boot:run
```

3. Or run the generated jar:

```bash
java -jar target/*.jar
```

4. Repeat for other services (e.g., start Eureka first, then ConfigServer if present, then provider services, then consumer services and admin server).

**Recommended order when a demo uses discovery/config:**

1. Start the Config Server (if the demo uses it).
2. Start the Eureka Server(s).
3. Start provider services (they will register with Eureka).
4. Start consumer services or front-end services.
5. (Optional) Start Admin Server to view registered instances.

---

## Common configuration tips

* Ports: Multiple demo apps often use fixed ports. If you need to run multiple instances on the same machine, open each app's `application.properties`/`application.yml` and change the `server.port` or run with a different `spring.profiles.active` and config values.

* Application names: Each service uses `spring.application.name` — ensure names are unique where required.

* Eureka client: If a client can’t register, check the Eureka server URL and network/port settings.

* Config server: Native config server reads files from its local `config` folder by default; ensure file names match `{appName}-{profile}.properties` if used.

---

## Useful commands

* Build all projects (from each folder):

```bash
mvn clean install
```

* Run with specific profiles or ports:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8085"
# or
java -jar target/app.jar --server.port=8086
```

---

## Contributing

This repo is primarily a personal/demo collection. Contributions, suggestions, or corrections are welcome:

1. Fork the repository.
2. Create a branch: `feature/your-feature`.
3. Make changes and commit with clear messages.
4. Open a Pull Request describing what you changed and why.

---

## Suggestions & next steps

* Add a short description file for each `BootMSProjXX-*` folder describing the purpose, required ports, and run order for that demo.
* Include `docker-compose.yml` examples to spin up Eureka + Config + Providers + Consumers easily.
* Add a unified `start-all.sh` script (or Windows equivalent) to start core servers in the right order.

---

## License

This repository currently has no explicit license. Add a `LICENSE` file (MIT, Apache-2.0 or similar) if you want to allow reuse.

---

If you'd like, I can:

* Create a more detailed README that documents **each** demo folder (list of expected ports, endpoints, and run order).
* Add a `docker-compose.yml` that starts a selected demo (Eureka + one provider + one consumer + config server).

Tell me which option you prefer and I will update the README accordingly.
