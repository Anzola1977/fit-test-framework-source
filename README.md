# FIT Test Framework

Scenario-driven database test framework. Flow: scenario -> deterministic generator -> transactional JPA DAO -> fresh DTO read -> assertions.

Packages: api, domain, generation, persistence/entity, persistence/repository, persistence/dao, service.

Run with `mvn test`.
