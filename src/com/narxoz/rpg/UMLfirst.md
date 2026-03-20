<<interface>> AttackAction
--------------------------------
+ getActionName() : String
+ getDamage() : int
+ getEffectSummary() : String


BasicAttack implements AttackAction
--------------------------------
- actionName : String
- baseDamage : int
--------------------------------
+ BasicAttack(actionName : String, baseDamage : int)
+ getActionName() : String
+ getDamage() : int
+ getEffectSummary() : String


ActionDecorator implements AttackAction
--------------------------------
- wrappedAction : AttackAction
--------------------------------
+ ActionDecorator(wrappedAction : AttackAction)
# getWrappedAction() : AttackAction
+ getActionName() : String
+ getDamage() : int
+ getEffectSummary() : String


FireRuneDecorator extends ActionDecorator
--------------------------------
+ FireRuneDecorator(wrappedAction : AttackAction)
+ getActionName() : String
+ getDamage() : int
+ getEffectSummary() : String


PoisonCoatingDecorator extends ActionDecorator
--------------------------------
+ PoisonCoatingDecorator(wrappedAction : AttackAction)
+ getActionName() : String
+ getDamage() : int
+ getEffectSummary() : String


CriticalFocusDecorator extends ActionDecorator
--------------------------------
+ CriticalFocusDecorator(wrappedAction : AttackAction)
+ getActionName() : String
+ getDamage() : int
+ getEffectSummary() : String