# Reflection

Your reflection should include 1-5 sentences for each of the questions below. Answers should be answered to the best of your ability, and reference your code submission. Up to 2 points will be deducted for each question that is omitted or answered incompletely.

1. **Inheritance Design:** Why is it useful to have `MeasuredIngredient` and `VagueIngredient` both extend a common `Ingredient` class, rather than an interface? What advantages does this provide for future development? Similarly, why is the `Quantity` hierarchy beneficial?

It makes sense for MeasuredIngredient and VagueIngredient to both extend Ingredient. They share stuff like name checks, figuring out identity, and other common behavior. An abstract class is better than an interface here because we can reuse both state and logic. This will make it easier to add features later on and improve the overall functionality. This is the same idea as the Quantity hierarchy: you can handle different types of quantities in a common way, but they still act distinct.

2. **Composition vs Inheritance:** `MeasuredIngredient` uses composition (has-a relationship) with `Quantity`, while `ExactQuantity` uses inheritance (is-a relationship) with `Quantity`. Explain when composition is preferred over inheritance and vice versa, using examples from this assignment.

The MeasuredIngredient works because an ingredient has a quantity. But isn't just a quantity by itself ExactQuantity, FractionalQuantity, and RangeQuantity are all quantity types, so let's use inheritance there. So the ExactQuantity, FractionalQuantity, and RangeQuantity are all types of quantities, so having them extend Quantity allows them to share common behavior while still providing their own specific implementations.


3. **Immutability:** Did you make your classes immutable (i.e., their state cannot change after construction)? Why or why not? What are the tradeoffs of immutable objects in a domain model like recipes?

Yes, those classes were designed to be immutable so their state can't change. You can only set values for these fields when you create them because they're private and final, and there are no ways to change them later. Having things unchanging in your domain model just makes sense. Since objects can't suddenly shift, it really cuts down on bugs and makes testing a cinch.Look, the big deal here is that when you want to change something, you gotta make a whole new thing instead of just tweaking the old one. That's not always ideal and means making more stuff, but for recipes, where things don't shift around much, it's generally fine.


4. **Type Safety:** How do the `Unit` and `UnitSystem` enums provide better type safety compared to using strings for units? Give a specific example of an error that enums prevent.

Enums like Unit and UnitSystem are a safer and more practical choice than strings. This is because they prevent typos and invalid unit inputs, which is a key part of our connection.For example, if you accidentally type "cupps" instead of "cups" and the code would still run. But by using enums, we make sure only proper set units are ever used, which means a stronger approach to catching errors early. This makes the code more reliable and easier to maintain.



5. **Challenges:** What was the most challenging aspect of this assignment? What strategy did you use to overcome it?

The most challenging part of this assignment was handling all the code like super and asserequals and @nullable or @nonnullable. Like tackling those toString() methods was tough, especially with the weird formatting for quantities.I made sure to cover all bases by testing every part of the plan before I called it done.


6. **AI Usage:** Did you use AI to help you with this assignment? If so, how did you use it? (Note that this information will be used to help improve the course, and **not** used to penalize you for using AI, as-per our [AI policy](https://neu-pdi.github.io/cs3100-public-resources/assignments/cyb1-recipes#ai-policy-for-this-assignment).)

I used AI to help reason through finding the error, validate formatting logic, and ensure alignment with the written specification. To help interpret the code, think through edge cases, and check that my design matched the assignment requirements.
