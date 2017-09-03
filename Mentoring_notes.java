Data Collections

    Handle colelctions as object.
    Java 8 hashmap use self balancing Binarry trees for buckets.
    Javascript use hash-table  as object implementaiton.
    Map load factor < 1 0,75 common. If bigger allocate more bucket.

    Iterable {itetator ()} <- Collecion {size()} } <- Queue <- Dequeue
                                                   <- Set <- SortedSet <- NavigatableSet
                                                   <- List
    Map {keyset(), valueSet()} <- SortedMap <- NaviableMap

    HashTable
        - key calculated and used to determine which bucket will be used. If there is multiple item in the bucket 
          equals will be used to decided whicj item is the searched one.

    Queue
        - FIFO
        - priority queue - comparable based
        - linkedlist

    Dequeue //TODO differense between queue and dequeue
        - ArrayDequeue
        - LinkedList

    Set
        - unordered
        - no implicates mathematical set //TODO what does it mean?
        - Not allow duplicates
        + HashSet, SortedSet, LinkedHashSet, TreeSet

    SortedSet
        - alements in order - natural or comparable
        - mustimplement compaerable interface   

    HashSet
        - backed by a hesh table (hashmap)
        - constant time for basics (add,remove, contains) O(1), O(n) in worst case
          if the hash function disposes the elements properly between buckets

    TreeSet
        - ordered
        - not synchronized
        - log(n) time for basics 
        - NavigableSet based on TreeMap

    List
        - ArrayList, vector, stack, LinkedList
        - keep the order of the elements
        - access via get(index)
        - allow duplicates
        - zero based - position access

    ArrayList
        - resizable array implementation
        - add O(n) amortized constant
        - size, isEmpty, get, set, itarator constant time O(1)
        - mustbe synced externally

    LinkedList
        - not synchronized
        - perits all element is NULL
        - fail fast if iterator modified
        - get O(n) amortized constant
        - add, remove, insert O(1)

    Map
        - Map keys to values
        - cannot contain duplicate keys
        - tree views: set of key, set of values, set of key-value
        - TreeMap ordered, Hashmap unordered

    HashMap
        - initial capacity / load factor (How full the hashtable is allowed te get ebfore its capacity 
          autoincreased, when it happen the table rehashed. Default is 75%)
        - not sychronized

    TreeMap
        - red-black tree based
        - NavigableMap - comparator
        - not synchronized

    SortedMap
        - synchronized

Recursion

    Single recursion ~ iteration is linear in time and constans in space
    Multiple iteration exponential in time and space. Cannot replaced with iteration or withouth explicit stack.
    Tree traversal is an example
    //TODO what is explicit stack?

    Recursive datatypes:
        - inductive (creation)
        - coinductive (accessing)

    Recursion types:
        - single / multiple
        - indirect
        - anonymus
        - structured
        - generative

    Base short circuitry when checking base case before make the recursive call.
    Iteration can be tail recursion.

    JWM can do tail call elimination. (Jump back to the original call not through the stack. 
    Should maintain pointer to that point.)


OOP Fundamentals

    class: bluepring or prototype
    object: instance of the classes
    
    class vaiables: 1 for a class
    instance variable: for instance
    member variable: both class and instance
    class method: class only have access to  class variable and input
    instance method: instance variable
    
    Accessed via pointer (heap) and constructed by a constructor
    dynamic dispach: it is the responsibilty of an object to had select the internal call //TODO what tis is mean?

    S - single responsibility (object only one reason to change)
    O - open / closed (no existing code change)
    L - Liskov substitution
    I - interface segregation (split interfaces, marker interfaces can be used to define data types,runtype)
    D - dependency inversion (through polimorphism)

    Encapsulation
        - binds together the data and functions => data hiding

    Inheritance 
        - is-a reletionship
    
    Composition
        - has-a relationship
        - object canhave another object as a variable
        
    Polimorphism
        - when not important that the method belongs to a parent class or descendant
        - overload, override (more poblic, more strick exeptions, use covariant return type)

    OO adventage: reusable, lose coupled, refactoring, modulizable

    Isolate business rules.
    Diamond problem. (Thats why java does not allow multiple inheritance.)
    Ambstraction help in information hiding. Lose cuopleing


Layered architecture

    Presentation layer
        - usernoriented functions
        - bridge pattern between busines logic
        - cna use service layer or business layer directly
    Service layer ( thats where external services call into. publi API.)
        Business layer
            - implement core functionalities of the system
            - encapsulates
            - expose service interfaces
        Persistance layer
            - provide access to data
            - expose interfaces to the business layer
        Database    
    Cross cutting conserns go through multiple layers. Serializable for broadcast.
    Layers can be separated intomdifferent tiers or phisival location.
    Layer isolation:lose couple between layer, encapsulation.
    One way communication: minimize dependencies, eliminate circular referencies, high level to low level comm.
    use events to revert.


Effective Java

    Buildere- Dont do it, dont do it until you have clear solution,
        - dont sacrifice sound architecture,
        - measure before doing it,
        - implementation problems can be fixed later,
        - avoid design decesions that limit performance.

    Static factory method vs. constructors
        + they have names
        + not required to create new obj when invoked
        + you can have multiple static factory method
        + return any subtype of returntype
        - makes hard to subclass
        - not distingisable from other static methods
        - hard to test

    Builder
        - simulates named optional parameters
        - check parameter after copy to the obj, illegal state exception
        - they can have multiple varargs
        - flexible

    Avoid creating unnecesarry objects
        - use stringbuilder
        - prefer primitive types to boxedmprimitives (autoboxing overhead).
    
    Eliminare obsolete obj references
        - sources are cashes, stacks, listeners, callbacks
        - store callbacks in weak reference type
        - heap profiler can be used 

    Avoid finalizers
        - never do anything time critical,
        - never ddpend on finalizer
        -performance penelty to using them.

    Obay general contract when overriding equals
        - reflexive, simmetric, transitive, consistent
        - non null not equals null
        - always override hashcode
        //TODO check contract between hashcode and equal

    Override toString
        - when practical should return all interesting information

    Considdr implementing comperable
        - comperable: naturalmordering 
        - retun -1 0 1
        - consistent with equals

    overrife clone judiciously
        - clonable interface 
        - override is expect to provide a proper functioning public clone íethod
        -incompatible with final fields refering to mutable objects
        - better providing copy or nothing

    Dont use raw types in new generic code
        - with row types you lose all the type safety and expressiveness benefit of generics
        - you van put only null to "collection<?>"
        - you must use raw types in class literals
        - type informationereased in runtime.

    Eliminate unchecked warnings
        - unchecked casts, method invokation, array creation, conversion
        -if code is typesafe add supressmwarning annotation with the smallest scope.

    Prefer list to array
        - array enforce type at runtime, covariant
        - list enforce type only compile time, invariant

    Favour generic types and methods
        - do not use wildcard type as return type
        - if type parameter appears only once in a method declaration, reőlace with wildcard

    upper bounded wildcards extends
    lower bounded wildcards super

Inheritance

    Final class: improve performance, methods resolve in compile time.
    final parameter: value of parameter cannot change after first assignment. 
    True for primitive types not for reference types.
    Cannot override static methods, and cannot use this keyword or super.


Nested classes / interfaces

    Defined inside class or interface
    Benefits: put related classes together, can access all member of enclosing class, increase encapsulation,
    can lead to more readabl code.
    
    Local class defined within code block. 
    Non-local class defined inside class.
    
    Inner class
        - cennot declare static member
        - has access all of the outer class members
        - outerClass.ennerClass innerObj = outerClass.new innerclass()
        - serialization strongly discouraged
    
    Static nested class
        - can be declared abstract or final, 
        - can extend another class,
        - outerClass.ennerClass innerObj = new outerClass.innerclass()
    
    Local inner class
        - can declare everywhere (for, if, cosnstructor)
        - accessing all members of the enclosing class
        - access to local variables only if they are final
        - cennot declare static member
        - can have constant variables
        - Not member of outer class
        - Can pass only final variables. 
        - Cannot define interface inside method.
    
    Anonnimous inner class
        - declare and instantate the class at the same time
        - cannot have explicit constructor, 
        - implicitly extends base class, 
        - return new anonimclass (){}

                      static      non-static             annonymus
    non-local   static nested     inner class               x
    local               x       local inner class   annonym inner class
    

Exceptions

    - Finally block always execute.
    - Multiple catch block: handle specific exceptions before general
    - chained exceptions: use constructor that takes another exception as argument.
    - dont ignore exceptions
    - use exceptions only for exceptional conditions
    - checked for recovery, runtime exc. for programming errors
    - favor standard exceptions

    try-witth-recource
        - compiler automatically translate it to try-finally,
        - you can aquire multiple recource in the block.    

    types:

    obj->throwable -> error (no point to catch them, abnormalcondition, jwm errors)
                   -> exception (base class of checked exceptions) -> runtime (base class for programing errors)
    Bad practice to extend error or throughable. Should extend exception or runtimeException
               

Refactoring

    Change the internal of software to make it easier to understand and cheaper to modify
    without changing its observable behavier.

    Why: improve design, make eaiser to understand, help find bugs, program faster, eliminate duplicates
    Downsides: difficult, dont if code does not work or goes live.
    Bad smell of code: duplicate, long class, long methods, switch statements, long parameter list, magic constans
    Unit testing: refactoring requires working unit tests. changing in code -> changing in test, run tests after every
    refactoring step.


Creational patterns

    Builder pattern
        - allows to create different flavours of an object, avoid constructor polution (telescoping - antipattern)
        - use when creation is multisteped (factori when 1 step)
        - good candidate to fluent interface //TODO what is fluent interface
        - encapsulate code for construction and representation

    Factory method
        - provides a way to delegate the instantation logic to child classes
        - call factory method instead of call a constructor
        - inherit from base class which has a create function and override it in child class.

    Static factory method
        - public static which return an instance
        - for example valueof
        - public static method call private constructor
        - unlike constructors they have names
        - not required to return a new object
        - can return any subtype of their return type

    Singleton
        - Ensure only 1 instance of a class is ever created
        - Anti pattern. Introdice a global state, makes code tightly coupled
        - private constructor, disable cloning and extension, create static variable for instance
        - permit lazy allocation
        - often singeltons: facade, state object, factories, resources, config files

        
Structural patterns

    Conserend with object composition or how entites can use each other. 
    Identify simple way to reduce relationship between entities.

    Adapter
        - Allow the interface of an existing class to be used as another interface
        - wrap incomplete object to make it compilable
        - adapter adapt not only the adaptee but all of its subclasses (if no new mothod added)
        - 2 way adapters are hard to implement, multiple inheritance not allowed in java

    Bridge
        - prefer composition over inheritance
        - decouple an abstraction from its implementation so that can vary independently
        - implementation details push to another hierarchy    

    Decorator
        - Dynamically changebehaivor of an object at runtime by wrapping them in a decorator object
        - can be recursive
        - make debugging system functionalites harder
        - adding new services dynamically
        - open / close principle

    Facade
        - provides simple interface to a complex system
        - reduce dependency, makes library easier to read
        - wrap poorly designed APIs with single well designed API

    Proxy
        - access control (by wrapping)
        - extra functionality can be provided (cashing, checking preconditions)
        - provide placeholder for a heavyweight object by maintain reference for it
        - represen the functionality of another calss
        
    Composite //TODO read about this
        - lets client to treat individual object on a uniform  manner
        - partitioning
        - group of object treated as a single object
        - compose object to a tree

    Flyweight
        - minimize memory by sharing as many as possible in similar objects
        

Behavioural patterns

    Identify common communication patterns between objects. Increase flexibility.

    Command
        - Allows to encapsulate actions in objects with all needed information, or trigger an event later
        - decouple client from receiver
        - can be used to implement transaction based systems
        - allow saving request in queue

    Iterator
        - present a way to access the elements of an object without exposing the underlaying presentation
        - decouples algorithms from containers
        - provide uniform interface for differnet colelctions
        - multithread safe when no addition of new element

    Mediator
        - add 3rd party object to control interaction between 2 very different object
        - help reduce coupling

    Observer
        - defines a dependency between objects, so when an object changes its state, all its dependants are notified
        - 1 way dependency
        - MVC pattern / event management
        - push modell -> send data
        - pull modell -> each observer response to pull data

    Strategy
        - switch algoritihm based upon situation / runtime
        - interchangeable algorithms

    Template
        - define the skeleton of how algorithm could be perfomed, but defers implementation those steps to the children classes
        - template method cannot be overwritten
        - input stream, output stream
    
    Visitor
        - add further operations without having to modify //TODO read abouz this
        
    State
        - change the behaivour of a class when the state change
        
    Chain of responsibility
        - chain of object
        - ente from command and keeps going until it finds a suitable handler
        - source of command objects and series of processing object


Defensive programing

    Makingsoftware behaive in a predictible manner dispte unexpected input or user actions.
    
    Pros:
        - general quality increase
        - source code comprehensible
        - software predictible despite unexpected inpits
        
    Cons:
        - unnecessary code -> more code more error
        - wasing runtime
        - increase maintanence cost

    Design by contract
    
        Software designers should define formal interface specifications, which extends the ordinary definitions with
        pre-posst conditions and invariants. Specification = contract. 

        Hoarc triple:
            - what does contract expect
            - what does contract garantee
            - what does contract maintain

        - verifiable interface for components, which extends the ordinary definition of abstract data types
        - subclasses in inheritance hierarchy allowed to weaken preconditions and strenghten post conditions and invariants
        - code should fail hard
        - contract typically check only debug mode during development (later disabled for performance)
        - does not replace regular testing strategies
        - always cannonicalize input //TODO what is this?

        Preconditions: Must be true prior to the execution of same code.
        Postconditions: Always be true just after the execution of same code. Also tested with assertions.
        Invariant: Is a condition that could be relied upon to be true during execution of a program.

        When to use
            - complex business rules in the domain model
            - specify contracts to ensure valid usage of API classes

    Secure programing: intent security, concentrate on the input, reduce bug is primary but
                       reduce attack surface is important.
    Offensive programing: Thrust on 3rd party library, focus on errors from outside.
    Legacy problems: might not designed for deffensive programming


Advanced data structures

    Heap
        - Specialize tree based data structure.
        - heap property: A is a parent node of B then the key of A is ordered 
          with repect to the key of node B with the same ordering
        - 2 type min() / max(parent are always greater or equal)
        - max effecient implementation if priority queue
        - common implementations is binary heap (only 0 node) //TODO this make no sense
        - implemented in array -> insert / delete -> balanced by internal operations

    Tree
        - Can be defines recursivly
        - defines a disect graph becaus it may have loops or several referenses to the same node 
        - storing data in a way taht makes efficiently searchable
        - represent sorted list of data
        - routing algorithms

    Self balanced tree
        - Binary tree only 2 node (left-right)
        - when modified subsequently rearanged
        - balance is not berfect but good enough searching, insertion, delete in O (log n )
        - allow efficiently ordered traversal
        - has minimum possible depth
        - color is 1 extra bit
        
    Red-Black trees
        - symmetric binary tree
        - balance is not perfect but quarantes O(log n) time for insert, search, recover
        - each node is eaighter red or black
        - root is black
        - NiL leaveas are black
        - if the node is red both children are black
        - every path for a given node to any NiL node contains the same number of black nodes

    Graph
    Consist of a finate set of nodes with a set of unordered edges. Edges can be associated with values.

    Types
        - simple
        - undirected

    Common problems: subgraph, coloring, routs.

    Concurent data structures: implemented with special primitive sync opertaion -> locks and non-blocking
    

JWM classloding

    JWM Heap
        - shared among all jwm threads
        - storage managemant technique may choosen according to the implementers system requirements
        - fix sized or expandeble
        - if computation require more heap than available out of memory error is throuwn

    Heap mem (GC, def size 64 MB) | non-heap memory (loaded classed, strings, constants, meata data, 64MB) |
    other (jwm code itself)

    Classloaders
        - dynamically loads calsses into the jwm
        - classes loaded on demand
        - responsible to locate libraries, reading contetnt and loading

    When jwm started 3 classloaders are used
        - Bootstrap: load core java librarires (jre, lib, written on native code)
        - Extensions: load from extension directory or specified external directory
        - System: load from classpath

    Every java classloader has a parent. Classloaders ask parent to load resources. Delegate to parent. 


Clean code

    Meaningful names
        - intentions revailing name
        - avoid disinformation, beware names that vary in small ways
        - use pronouncable names
        - use searchable names, single letter variable used only for local, 
        - length of name should be correspond to the size of it scope
        - avoid encoding -> hungarian notation
        - class names noun, method names verbs
        - meaningful names: avoid mental mepping, 1 word / concept, add meaningful context, dont pun

    Functions and methods
        - functions should be small
        - should not be large enough to hold nested structures
        - do one thing and do it well (error handling is one thing)
        - one level of abstraction per function
        - read the code top down (Step down rule), function followed by the next level of abstraction
        - ideal argument number 0
        - side effect: promise one thing but it also do another
        - command query separation -> functions eighter do something or answare something
        - never trust input: terminate on suspicios input and use whitelist strategy
        - fail fast: stop normal operation rather than attempt to continue

    Comments
        - comments are lie
        - good comment that oyu dont write
        - expalnation comment -> et least you knowwhy the other programerr vent with the implementation

    Formatting
        - vertical formating read like a newspaper article.
        - blank lines to separate
        - code that tightly related should be appeare vertically dense
        - variables should be declared as close as possible where used
        - horizontal formatting how long a line should be
        - 80-120 char
        - never need to scroll
        - use intendation

    Error handling
        - use exceptions rather then error codes
        - use unchecked exceptions
        - checked exceptions violate open/close principle
        - dont return null -> through exception or return special case object
        - dont pass null
        
    Object
        - hiding iimplementation is matter of put a layyer of function between variables, its about abstraction
        - procedural code (data structure) makes easy to add new unctions without changing te existing data. 
        - OO code makes it easy to add new classes withoud changing functions
        - procedural makes hard to add new data structure -> all functions must be changed
        - OO makes hard to add new functions -> all classes must be changed
    
    Boundaries
        - code on boundaries need clear separation and test defined expectations
        - wrap 3rd aprty code, adapter pattern
    
    Unit tests
        - 3 law of TDD: 1, write failing unit test before production code
                        2, do not write more failing code than sufficent
                        3, do not write more prod. code than sufficent to past the tests
        - test code is as important as productioin code
        - clean test = readable
        - single assert is just a guidline
        - single concept / test
        - F test should be fast
        - I test should be independent, not depend on each other
        - R test should be repetable in any environment (prod, test, train)
        - S test should be self validationg -> return with boolean
        - T test should be timley, writen just before prod. code        

Generics

    - Enable types (classes, interfaces) to be parameter when defining classes, interfaces and methods
    - strong type check at compile time
    - elimination of casts
    - generic algorithms
    
    A generic type is a generic class or interface that is parametrized over types class name <T1>
    Raw types legacy code Box <T>; new Box()
    Type erasuer: Erase all type param and replace with its first bound if it is base or object.
    
    Generic methods, scope is limited to the method
    Bounded types param restrict the type
    
    Inheritance, can pass subclasses of a parent. A and B myCall(A) has NO relationship to myCall(B) regardless
    of whether A and B relatd or not.
    
    Wildcards ? => unknown type. Never used as a type argument for a generic method invoction.
    
    Unbounded wildcards: List <?>
        - method that can be implemented using functionality provided by the object class
        - using methods in the generic class that dont depend on the type parameter -> list.size, list.clear
    
    Upper bounded wildcards to relax the restriction on a variable. Will accept any subtype of a parent class.
    Upper bounded always extends
    
    Lower bound wildcards restrict the type to be type or super type. Lower bound alwys super.
	
2017-07	
	
Domain Driven Design
	
	Develop software for complex needs by  deeply connecting the implementation to the model of core business concepts.
	
	- Place the project focus on the core domain and logic,
	- base complex design on a model,
	- initiate creative collaboration between tech and domain experts.
	
	Model: System of abstracation that describes selescted aspect ao a domain and can be  used to solve problems related 
		to the domain.
	Ubiquitous language: Language structured around the domain model and used by all team member.
	Bounded context: Explicitly define the context within model (org, team, code ba se, db schemas). Keep the model 
		strictly consistentwithin boundaries.
	Entity: Defined by a thread of continuity and identity.
	Value object: Contain attributes but have no conceptual identity
	Aggregate: Collection of obejcts that are bounded together by a root entity.
	Repository: Methods for retrieveing domain objects should be delegated to a specialized repository object.
	Factory: Methods for creating domain ojects should be delegated to sepcific factory object.
	Anti-corruption layer: Bounded context use the service of another one, but aim to minimize impact of changes by
		intruducing a set of adapters -> anti-corruption layer.
		
Architectural patterns

	- Layered architecture,
	- event driven,
	- mikro-kernel
	- mikroservice,
	- space based.
	
	Architectural patterns are reusable solutions to common promlems. Simiéar to design patterns, but have broader scope.
		Address issues like: hardware limitation, high availability, mimimize business risk, celar / smaller
		
	EDA (event driven architecture): Promoting events. Event occure, notify message travel. Used between loosly cooplead
		components and services. More normalized to async and unpredictible environment.
		
	Microservices: Fine-gread services and lightweight protocols. Improves modularity, easier to understand. Paralel development.
		Enable continousl development and deployment.
		
	SOA (service oriented architecture): A service is a discrete unit of funtionality, that can be accessed remotely. 
		Service: self contained, represents business activity with black box for customer, may consist of underlaying services.
		Promote lose coupling. Can be implemented with web services.
		
	Space-based architecture: For linear scalability of stateful applications (high performance). Application is built out of
		processing units. They are independent and can scale by adding the.
	
	Centralized messaging topology: Consist of large data center, hosting all server resourcies (domain controller, exchange
		servers, catalog server). Softwaare upgrade can be rolled out from centralized location. Uninterruptatble power source,
		hot / cold site.
		
SOA and Microservices antipatterns

	Autgenerated stovepipe: Occourse when migrating an existing sw sstem to a distributes infrastructure. Convert existing inter-
		faces to distributed interfaces
	
	Stovepipe enterprise: SW structure that inhibits change. LAck of coordination and plannig across a set of systems.
	
	Stovepipe system: Subsystems are integrated in an addhoc manner, using multiple strategies. 
	
	Jumble?: Horizontal and vertical design elements are intermixed. //TODO what is horizontal, veritcal design elements

	Cover your assests: Document driven sw process often produce less-then-usefull requirement and specification. The author
		evade making important decisions.
		
	Vendor lock in: Highly dependant upon proprietory architecture //TODO so vwhat?
	
	Design by comitee: Creates overly complex architecture, that lack coherence.
	
	Reinvent the wheel: Lack of techology transfer between project leads. Design knowledge is burried on legacy assets.
	
Basic algorithms
	
	Big O notation: Classify algorithms according how their runnig time or space requirements grow as the input size grow.
		O(1) constant, O(logn) logaritmic, O(n) linear
		
	Divede and conqurer alg.: Based on multibranched recoursion. reqursivly breaking down problem into sub problems of the 
	same type, until easy to solve. Sorting multiply large numbers, FFT.
	
	Randomized alg.: Employes a degree of  randomness as part o the logic, (Monte Carlo sim.)
	
	Quicksort: 2-3 times faster the merge or heapsort. comparison sort, can be any type with less-than relation. Can operate
		in place on an array, require small addition of memory. worst case O(n^2). Devide and Conq.
		
	Mergesort: Efficient comparison-based sorting. Devide into 1 element merge them repetadly to produce new sorted sublist 
		until 1 list remain.
		
	Greedy alg.: Locally optimize choise at each stage to hope find global optimum.
	
Multithread

	Thread vs process: Threads run in a shared memory space while processes run is separeted memory spaces. Thread is a sub-
		set of process. Process consist of multiple threads. Process use interprocess communication. Process does not have 
		control of sibling processes, threads does.
		
	Thread types: JVM will wait for every user thread to finish before shut down. Deamon (low priority, suitable for 
		non-critical jobs) can be terminated. Normal thread created from main thread. Deamon need to call setdeamon() 
		JVM create deamons (fe. GC)
		
	Benefits of multiple threads: 
		- Improve performanc and concurency,
		- simplified coding for remote procedure calls,
		- simultaniosly access to multiple apps,
		- reduce number of required servers.
		
	Risks:
		- Difficult to write code,
		- difficult to debug, testing,
		- difficult to porting existing code,
		- difficult managing concurency.
		
	Safty hazards:
		- race conditions: output depends on sequence or timing of uncontroled events.
	
	Liveness hazards:
		- deadlock: each member of a gruop is waiting for some other member  to realies lock.
		- livelock: ??
		- starvation: ??
		
	Performance hazards:
		- Poor service times,
		- resposivness,
		- scalability,
		- resource consumption,
		- througput.
		
	Define and start threads: 
		- Provide runnable object (interface with run method) this passed to a tunnable constructor,
		- Subclass thread, provide own implementation of run method.
		- Both should inivoke thread.start()
		
	Terminate/interrupt thread:
		- Interrupt is indacate that thread should stopand do something else. A thread sends interrupt by invoking 
		"interrupt" on thread object. Thread must support its own interrupts (internal flag, getter/setter)
		- Terminate, internally (return or run ends), externally (system exit, interrupt, kill or stop(), thread 
		interrupt exception)
		
	Thread scheduler: Part of the JVM or OS
		- Java does not force VM to schedule threads in a specific manner (platform dependent)
		- You only need to think about how java schedule threads only atleast one your program is thread heavy.
		- Thread states: initial-runnable-blocked-terminated
		
	Set thread priority: Number between 1-10. (preemptive scheduling = by priority) Norm priority = 5, min =1 max=10
		Highly important stuffs can be done on a synhronised way.
	
	Thread gruops: Group thread in a single object. Suspend, resume, interrupt with a single method call.
		Join method, wait 1 thread after start another.
		
	Syncronized: Lock object for any shared resources, auto aquires the lock and relase it. 
	
	Volatile: Garanties visibility of changes accross threads. Prevent cashing (L2-L3)
	
	Final: Force compiler to complie initilization for that field, before constructor compile.
	
	Thread states:
		New: Creste instance of thread class before start.
		Runnable: After invoking start(), but scheduler not selected yet.
		Running: Thread scheduler select it.
		Non-Runnable(blocked): Alive nut notelegate to run.
		Terminated: Dead/terminated, run() exit.
		
	Join(): Currently running thread stops execute until the thread it joins completes.
	Yield(): Currently running thread to yield to any other threads of same priority that are waiting to be scheduled.
	
	Sleep use CPU, waiting yield is platform dependent.
	
	wait/notify/notify all: Its for thread syncronization, observer like.
	
	Interrupted Exception: In java, cancellation of running thread is cooperative. It is for non-runnable stateed threads
		Should get out of the way as soon as possible. Handle strategies:
			- Rethrow: classes which implement blocking operations
			- Catch, restore, terminate: Classis inplement an existing interface (restore flag)
			- catch, terminate: subclass of thread
			
	Shutdwown hook:When VM shut down it will start all registered shutdown hook. When all finish run all uninvoked finalizers
		(if enabled) finally halt VM. Perform cleanup resource or save state when VM shuts down normally. (strl+C, System.exit())
		
	Java.util.concurrent: small standardized framework. Parts: executors, queues, timing, synchronizers, collections, 
		memory consistency properties. Used as buildong blocks for creating concurent classes or applications. Expose
		low-level Compare-and-swap (CAS) hardware instructions.
		
	Executor framework: Interface for definfing cosutm thread-like subsystems. Executor service manages queues, schedule 
		tasks and shutdown (await termination, shutdown, isShutDowns). Multiple concrate class implementatioins. Task 
		submission is decoupled from task execution policy. Get executor through factory.
		
	Future pattern: Represent the result of an asyncron computation. Methods for check the computation is complate and retrive
		result. Cancellable. Can be blocking.
	
	Completition service: Decouples the production of asyncron tasks from consumption of the results. Producers submit tasks,
		consumers take completed and process their results.
		
	Lock: syncronization mechanism more sophistcated then synchronized blocks. It is an interface ->
		has framework.
	
	Reentrant lock: Owned by the thread, which successfully locked, but not unlocked. Return immedietlyif current thread
		already has the lock. concreate implementation of lock interface. Fairness, lock interruptly, ability to timeout.
		Drawbacks -> try/catch block. Reentrant = obtain lock multiple time.
		
	Timer and timer task class: Provide halp for controlling time-out based operations. Implementations make "best effort"
		to detect time-outs. Schedule tasks. Timer tasks should not be very long. Timer is a Thread and can assign to it
		timer tasks.
		
	Semaphore: Maintain all setes of permits. For example limit concurency access to certain parts. use try/finally to
		properlyrelease the semaphore.
		
	Phaser: Thread synchronization mechanism. You have wait for threads to arrive before continue or start another set of 
		tasks. 
	
	CountdownLatch: Allows thread to wait for one or more threads before start processing. Not reusable once count readch zero.
	
	CyclicBarrier: Like countdownLatch but reusable by call reset().
	
	Fork-joint framework: Done in-memory algorithm. Responsible to create new task object which can create subtask and wait
		to finish them. Maintain pool and executor to task.
		
	Atomic variables: Get/set that work like read/write on volatile variables. Atomic = threadsafe without synchronized
		keyword. Heavily use CAS (hardware supported)
	
	Concurent hashmap: Implementation of concurent map interface. Summultaniosly allow 16 thread to read/whrite without
		external sync. Very scalable.
	
	CopyOnWriteArrayList: Implement List interface. Copy list each time it change. Expensive to largge lists. Ok for few 
		modificaion with many reads. Iterators use snapshot of the array (not reflect change).
		
	ConcurentSkipList: Implementation of concurentNavigationalMap. Element sorted based on their natural orders keys. 
		Allows fast search in an ordered sequence of lements. Quaranties O(logn) for msot operations.
		
	Blocking queue: Thread safe to insert or retrieve element from it. Block request of insert new elemnt when queue is
		full, or remove if empty. All with timeouts. Nice way to make Producer-Costumer pattern. 
		
Softskill
	
	Kanban: WIP - work in progress unot for strategies, no rules
	Scrum: Scrum master, dev team, product owner
	
	Scum: has roles, time based, ceremonies, descriptive, can be too rigid
	Kanban: no rules, no ceremonies, only quidence, no time based.
	
	As D3 you have more responsibility, its is borader like L2. People management, decision making. 
	
	A story point consist of: Effort (hour) - Risk - Complexity; pick 1 storypoint as reference
	
	Time managemant technies: pomodoro technic, TODO list, Book your time in the calendar
	
	Delegation: not have to be done by who is delegated, needs to be done.
 	Assignment: Clear responsibility to who was assigned, who will do.
	
	Risk managemant: Spike stories, proof of concept, return of invests //TODO get some info about these
	
	User story: Direct, timable, testable, aceptance creteria, doable, definitaion of ready, user story format. 