module GuardsSpec (spec) where

import Test.Hspec
import Test.Hspec.QuickCheck

data TicketPrice = Free
                 | Cost Float
                     deriving (Show, Eq)

discountCalc :: (Num a, Ord a) => a -> TicketPrice
discountCalc age
  | age < 10 = Free
  | age >= 10 && age < 60 = Cost regular
  | age >= 60 = Cost senior
  where regular = 35
        senior = regular - (regular * 0.10)

spec :: Spec
spec
  = do describe "Guards" $
         do it "narrows a specific type with conditions" $
              discountCalc 30 `shouldBe` Cost 35
