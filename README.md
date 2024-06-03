Section 2

![image](https://github.com/ducnguyen55/assignmentHRS/assets/38359443/f39d94d1-6bd9-4883-8158-d7cb50e822a1)

This diagram illustrates the event-driven architecture for the hotel reservation system on AWS:

External APIs such as booking and payment gateways interact with the system.

The External API Integration service, implemented using AWS Lambda, integrates with external APIs.

Amazon EventBridge serves as the central event bus for communication between microservices.

Microservices, including the Booking Service, Payment Service, Notification Service, and External API Integration Service, are implemented as AWS Lambda functions.

Booking Service used for handling create, update, view booking.

Payment Service used for payment

Notification Service used for email confirm, feedback, communication, survey.

External API Integration Service used for handling API is better. Supporting for extend and security

The system is deployed across multiple Availability Zones (Multi-AZ Deployment) for fault tolerance.

Data persistence is handled by Amazon RDS, providing a highly available and scalable database solution.

This architecture provides a scalable, highly available, and fault-tolerant solution for the hotel reservation system and leveraging AWS services.
