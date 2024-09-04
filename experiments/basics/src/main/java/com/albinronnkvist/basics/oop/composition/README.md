# Composition

Composition is a stronger form of aggregation where the part cannot exist independently of the whole. When the whole is destroyed, the parts are also destroyed.

## Examples

- Class A strongly has a Class B: If Class A has a composition relationship with Class B, then B is a part of A and cannot exist without A.
- Real-world analogy: A "House" class might compose a "Room" class, where a room cannot exist without the house.

## Java implementation

Composition is implemented by including an instance of another class as a field in the class.