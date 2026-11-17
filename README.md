# Gym Management System

Final project for the Design Patterns course.
A console application in Java that manages gym members, memberships, payments and group classes.

## Team and patterns

| Student | Pattern 1 | Pattern 2 | Type |
|---------|-----------|-----------|------|
| Kaisar  | Builder (`builder`) | Factory Method (`factory`) | Creational |
| Darkhan | Decorator (`decorator`) | Adapter (`adapter`) | Structural |
| Ali     | Observer (`observer`) | Strategy (`strategy`) | Behavioral |

## Project structure

```
src/
├── Main.java                         <- the only class outside pattern packages, tests everything
├── builder/
│   ├── product/                      <- TrainingPlan (the object we build)
│   ├── builders/                     <- TrainingPlanBuilder + GymTrainingPlanBuilder
│   └── director/                     <- PlanDirector (ready-made plans)
├── factory/
│   ├── product/                      <- Membership + Basic / Premium / Vip
│   └── creator/                      <- MembershipFactory + 3 concrete factories
├── decorator/
│   ├── base/                         <- MembershipDecorator (abstract)
│   └── addon/                        <- PersonalTrainer / Sauna / Locker
├── adapter/
│   ├── target/                       <- PaymentProcessor (what our system expects)
│   ├── adaptee/                      <- KaspiApi, ForeignCardApi (third-party APIs)
│   └── adapters/                     <- KaspiPaymentAdapter, ForeignCardPaymentAdapter
├── observer/
│   ├── subject/                      <- Subject, GymClass
│   └── subscriber/                   <- GymObserver, Member, FrontDeskScreen
└── strategy/
    ├── context/                      <- PriceCalculator
    └── pricing/                      <- PricingStrategy + Regular / Student / LongTerm
```

## How the patterns work together

1. **Factory Method** creates a membership (Basic, Premium or VIP).
2. **Decorator** adds extras to it (personal trainer, sauna, locker) and changes the price.
3. **Strategy** calculates the final price (regular, student, long-term discount).
4. **Adapter** lets the member pay with Kaspi or a foreign card through one `PaymentProcessor` interface.
5. **Observer** sends notifications to members and the front desk when a class time changes or a class is cancelled.
6. **Builder** creates a personal training plan for the member step by step (goal, days, exercises, trainer, nutrition).

## How to run

Requirements: JDK 17 or newer.

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

Or open the folder in IntelliJ IDEA, mark `src` as Sources Root and run `Main`.

## Principles used

- **SRP** - every class has one job (e.g. `PriceCalculator` only calculates, `PlanDirector` only knows the order of steps).
- **OCP** - a new discount or add-on is a new class, existing code is not changed.
- **LSP** - any decorator can be used where a `Membership` is expected.
- **ISP** - small interfaces (`GymObserver` has one method, `PaymentProcessor` has one method).
- **DIP** - `Main` and `PriceCalculator` depend on interfaces (`PaymentProcessor`, `PricingStrategy`), not on concrete classes.
- **DRY** - common forwarding code is written once in `MembershipDecorator`, ready-made plans once in `PlanDirector`.
- **KISS** - plain Java, no frameworks, console output.
