use MyDef.square;
use OtherModule.mult;

@test
def usingModules(): Bool = square(3) == 9

@test
def usingModuleInFolder():Bool = mult(3,4) == 12
   