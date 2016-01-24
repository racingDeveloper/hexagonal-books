# hexagonal-books
[![Build Status](https://travis-ci.org/gabrieletondi/hexagonal-books.svg?branch=master)](https://travis-ci.org/gabrieletondi/hexagonal-books)

sample hexagonal architecture application



* ##application##
  
  the domain itself. contains use-cases, entities, value-objects etc... and defines the secondary ports.
  
* ##inmemory-repository##
  
  secondary adapters in-memory implementation.  
  
* ##console##
  
  primary adapter console implementation, it delivers the app through the terminal console.
  
* ##rest##
  
  primary adapter HTTP (rest) implementation, it delivers the app through rest interface.  
  

