cmake_minimum_required(VERSION 3.6)
project(threads)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES trabalho_v1.c)
add_executable(threads ${SOURCE_FILES})