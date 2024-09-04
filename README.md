# Parking Management System
## Personal Project Overview
This project is inspired by my summer job experience at a parking facility. The goal is to develop a fully functional and practical application that mirrors real-world needs. The application is designed using Domain-Driven Design (DDD) principles, with a focus on scalability and maintainability. Currently, it operates with an in-memory database (HashMap) and does not rely on Spring Boot, allowing for a clean, framework-independent architecture.

## Project Goals
he finished application will include the following features:

- Client Registration: A system to register new clients, including subscription management for regular users who pay monthly fees.

- Monthly Payments: Automated and manual payment processing for monthly subscriptions.

- Parking Slot Management: A system to monitor available and occupied parking slots in real-time.

- Pay-per-Minute System: A feature allowing non-registered users to pay based on the duration of their stay.

- 24-Hour Payment Option: An alternative payment option for non-registered users, offering a flat rate of €25 for a 24-hour period.

- Flexible Architecture: The project is structured to support future expansion, such as the integration of external payment gateways, the addition of a persistent database, or migration to a web-based interface.

- Extensible Design: By applying DDD principles, each domain context (e.g., Clients, Parking, Slots) is encapsulated with its own entities, repositories, and services. This modular approach ensures that the system can scale as individual components grow or require updates.

## Technical Details
Architecture: Domain-Driven Design (DDD)
Data Storage: In-memory database (HashMap) for rapid prototyping and testing
Frameworks: No reliance on Spring Boot or other frameworks, ensuring the core logic remains independent and easily portable.
## Future Enhancements
As the project evolves, the following enhancements are planned:

Integration with a Persistent Database: Replace the in-memory storage with a relational database to handle large-scale data and provide persistence across sessions.
Web Interface: Develop a web-based user interface to allow remote management and user interaction.
Enhanced Payment Processing: Implement integration with external payment gateways for a seamless payment experience.
Comprehensive Reporting: Add features for generating detailed reports on parking usage, client subscriptions, and revenue.
