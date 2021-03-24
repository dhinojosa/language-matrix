module Shapes where

type Length = Int

type Width = Int

type Radius = Int

type Base = Int

type Height = Int

data Shape
  = Rectangle Length Width
  | Circle Radius
  | Triangle Base Height

area :: Shape -> Double
area (Rectangle len wid) = fromIntegral (len * wid)
area (Circle rad)        = (fromIntegral rad ** 2) * pi
area (Triangle ba he)    = fromIntegral (ba * he) / 2.0
