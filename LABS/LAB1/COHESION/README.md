The High Cohesion principle is one of the fundamental concepts in the GRASP (General Responsibility Assignment Software Patterns) framework. High cohesion refers to the degree to which the elements inside a module (or class) belong together. A class is considered highly cohesive when its responsibilities are closely related and focused on a single purpose. This leads to better maintainability, readability, and reusability.

Key Points of High Cohesion

Single Responsibility: A class should focus on one responsibility or functionality. This makes it easier to understand, modify, and test.

Encapsulation: Cohesive classes tend to encapsulate their data and behaviors, minimizing dependencies on other classes.

Ease of Maintenance: With high cohesion, changes in one class are less likely to impact others, making the system easier to maintain.

Reusability: Classes that have a single, well-defined purpose are easier to reuse in different contexts.

Improved Readability: When a class has a focused purpose, it is easier for developers to read and understand its functionality.




Explanation of the Improved Example

High Cohesion:

The Book class now only manages book-related data and behavior (i.e., title, author, and printing details). All responsibilities related to the Book itself are focused within this class.
Separation of Concerns:

The responsibility of saving the Book to a database has been moved to a new class, BookRepository. This class focuses solely on data persistence, which is a distinct concern.
Maintainability:

If the database storage logic changes, only the BookRepository class needs to be modified, while the Book class remains unchanged.
Reusability:

Other parts of the application can utilize the Book class and the BookRepository independently, promoting reuse across different modules.
Conclusion:

High cohesion within classes is a vital aspect of software design that leads to cleaner, more maintainable, and reusable code. By ensuring that classes have focused responsibilities, developers can create systems that are easier to work with and less prone to bugs as they evolve. Adopting the High Cohesion principle is an effective way to enhance the overall quality of software architecture.
