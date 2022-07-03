cmake_minimum_required(VERSION 3.10)

# set the project name
project(cpp-make)

# add the executable
add_executable(arrays/using_arrays.cpp)

# specify the C++ standard
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)