# Abstract Factory Design Pattern in Java: Notification System Example

This repository provides a clear and well-documented implementation of the **Abstract Factory** design pattern in Java. The example is centered around creating a notification system that can produce families of related objects (notifications and their corresponding templates) without specifying their concrete classes.

## Table of Contents

1.  [What is the Abstract Factory Pattern?](#what-is-the-abstract-factory-pattern)
2.  [Real-World Analogy: A Meal Factory](#real-world-analogy-a-meal-factory)
3.  [Project Structure](#project-structure)
4.  [Core Concepts Illustrated](#core-concepts-illustrated)
5.  [How to Compile and Run](#how-to-compile-and-run)
6.  [Key Benefits of the Abstract Factory Pattern](#key-benefits-of-the-abstract-factory-pattern)
7.  [When to Use This Pattern](#when-to-use-this-pattern)
8.  [License](#license)

## What is the Abstract Factory Pattern?

The **Abstract Factory** is a creational design pattern that provides an interface for creating **families of related or dependent objects** without specifying their concrete classes. It's like a "factory of factories," where a main factory delegates the responsibility of object instantiation to one of its subordinate factories.

This pattern is useful when a system needs to be independent of how its products are created, composed, and represented. It allows you to use different product families interchangeably.

## Real-World Analogy: A Meal Factory

Imagine two fast-food chains: `SinghBurger` and `KingBurger`. Both are "meal factories" that can produce a `Burger` and a side of `GarlicBread`.

-   **`SinghBurger` Factory**: Produces a `BasicBurger` (with a regular bun) and `BasicGarlicBread`.
-   **`KingBurger` Factory**: Produces a `BasicWheatBurger` (with a wheat bun) and `BasicWheatGarlicBread`.

Here, the "family" of products is either "regular" or "wheat-based." When you order from `SinghBurger`, you get a consistent meal from the "regular" family. You don't mix a regular burger with wheat-based garlic bread. The Abstract Factory pattern enforces this consistency. Our notification system works the same way, ensuring an "urgent" notification uses a "formal" template.

## Project Structure

The project is structured to clearly separate the roles of products, abstract factories, and concrete factories.

.
└── src/
├── AlertService.java               // The client application (main class)
├── Notification.java               // Abstract Product A: Notification interface
├── EmailNotification.java          // Concrete Product A1
├── SMSNotification.java            // Concrete Product A2
├── NotificationTemplate.java       // Abstract Product B: Template interface
├── FormalTemplate.java             // Concrete Product B1
├── CasualTemplate.java             // Concrete Product B2
├── NotificationFactory.java        // The Abstract Factory interface
├── UrgentNotificationFactory.java  // Concrete Factory 1 (produces a formal family)
└── MarketingNotificationFactory.java // Concrete Factory 2 (produces a casual family)


## Core Concepts Illustrated

1.  **Abstract Products (`Notification`, `NotificationTemplate`)**
    -   These are the interfaces for a family of related products. In our case, every notification needs a `send()` method, and every template needs a `format()` method.

2.  **Concrete Products (`EmailNotification`, `FormalTemplate`, etc.)**
    -   These are the specific implementations of the abstract products. They represent the distinct variations of objects that can be created. For example, an `EmailNotification` and a `SMSNotification` are concrete products of the `Notification` type.

3.  **Abstract Factory (`NotificationFactory`)**
    -   This is the core interface that declares a set of methods for creating the abstract products (e.g., `createNotification()` and `createTemplate()`). It defines the contract for all concrete factories.

4.  **Concrete Factories (`UrgentNotificationFactory`, `MarketingNotificationFactory`)**
    -   These classes implement the `AbstractFactory` interface to create a specific family of products.
    -   `UrgentNotificationFactory` creates formal notifications (`FormalTemplate`).
    -   `MarketingNotificationFactory` creates casual notifications (`CasualTemplate`).
    -   This ensures that the products created by a single factory are compatible and work together seamlessly.

5.  **Client (`AlertService`)**
    -   The client code works with the abstract interfaces (`NotificationFactory`, `Notification`, `NotificationTemplate`).
    -   It decides which concrete factory to use (e.g., `UrgentNotificationFactory` for a system alert). Once the factory is chosen, the client never has to worry about the concrete product types again, thus decoupling the client from the implementation details.

## How to Compile and Run

1.  **Save the Code**: Make sure all the Java files listed in the project structure are saved in the same directory (e.g., `src/`).

2.  **Compile**: Open a terminal or command prompt, navigate to the `src` directory, and compile all the Java files.

    ```bash
    javac *.java
    ```

3.  **Run**: Execute the main client class, `AlertService`.

    ```bash
    java AlertService
    ```

#### Expected Output:

--- Running Urgent Notification Scenario --- 📱 Sending SMS...
Formal SMS Notification
Message: System is going down for maintenance in 1 hour. Regards, System Administration
--- Running Marketing Notification Scenario ---
📧 Sending Email...
✨ Hey there! Just a quick update for you via Email: Our summer sale just started! Get 50% off. ✨

Marketing SMS is not supported by this factory.

## Key Benefits of the Abstract Factory Pattern

-   **Isolates Concrete Classes**: The client is completely decoupled from the product implementations. You can add new product families without changing the client code at all.
-   **Enforces Product Families**: It guarantees that the products created by a factory are from the same family and are designed to work together, ensuring consistency.
-   **Promotes Consistency**: The look and feel of products from a single factory will be consistent (e.g., all "urgent" notifications have a formal style).
-   **Simplifies Exchanging Product Families**: To change the behavior of the application, you only need to change the concrete factory instance used by the client.

## When to Use This Pattern

Use the Abstract Factory pattern when:

-   Your system needs to be independent of how its products are created.
-   Your system is configured with one of multiple families of products.
-   You want to provide a library of products but only want to reveal their interfaces, not their implementations.
-   You need to enforce dependencies and constraints between related products.

## License

This project is licensed under the MIT License.