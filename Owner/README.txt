This microservice contains to entities - OwnerEntity and AddressEntity.
Port is 8083 by default, but can be configured in application properties.

Multiple owners can be registered to the same address, but an owner can typically have only one address.

Example HTTP requests:

Create a new address
POST http://localhost:8083/addresses street="123 Main St" city="New York" postalCode="10001"

Create a new owner
POST http://localhost:8083/owners name="John Doe" email="john.doe@example.com" address.id=1
