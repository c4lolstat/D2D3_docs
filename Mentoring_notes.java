OCA jegyzetek

1. fejezet

- Period has a reserved meaning in JVM.
- Java only looks for class names in the package
- java.lang automatically imported
- Explicit import > wildcard

- Instance initializers are not in any method
- Init order: Fields and instance init in order => constructor 
- by default Java assume you are define an int
- you can add underscore to numerals 1_0

- legal identifiers: must begin with letter or symbol(_,$), other place number is 	ok, cannot use 	reserved words. 
- Static keyword => class variable
- System.gc() not guarantee to run
- finalize() called only once or none
- no pointers and operator overload in Java

2. fejezet
- post unary cames before pre unary operators
- double logic operators are short circuit operators
- if two values have different type Java promot to the bigger one
- automaticali promot integral to floating point

- byte, short, char first promoted to int any time – unnary operators are excluded
- casting primitive types require when go from large to smaller datatype
- *=, etc automaticvaly cast the result
- switch statement not support boolean and long and there wrappers
- i=i++; => assign the old value

3. fejezet
- String pool collect all strings literals
- do not use new String, it is not utiliesing the string pool
- Stringbuffer is threadsafe
- Sort order – number, letters, uppercase, lowercase

- string and stringbuffer not comparable with ==
- String a=”c” a+=2 becames a=a+2 => „c2”
- array cant change size, but can have multiple dimensions
- array and arraylist is ordered and have indexes

- neither is immutable, elements can change value
- array does not override equals so uses object equality
- arraylist override equals and defines it as same elements in same order
- dates are immutable
- period not allow chaining, only the last is considered.

4. fejezet
- Only 1 vararg at the last place
- if you do liskow replacement stuf you dont have access to protected methods and variables. For use of protected modifier you have to be on a proper referenc type.
- Static initializer is first assignment
- Static variable can be assigned only at declaration or static block

- Calling methods on reference object change the caller
- access modifiers and exceptions irrelevant for method overloading and return type, and static
- this() should be first statement
- init order: super > static > instance param > constructor

- getter for boolean must start with 'is'
- default constructor added only no constructor was inplemented
- both instance and static initializer can access a static variable

5. fejezet
- inherit from finnal class result a compiler error
- protected and private only for inner classes
- only one public class per file
- abstract class and method cannot be final

- abstract cannot be private
- first subclass of abstract have to implement all methods
- an interface inherits all abstract methods
- interface can implement a default method and must be marked with default keyword and implement method body

- java 8 support static methods in interfaces and not inherited
- casting from sublacc to superclass no need explicit cast
- casting from superclass to subclacc need explicite cast
- casting from subclass to subclass no need explicite cast

- private methods always hidden
- public, protected methods may be overriden nit hidden
- variables may only be hidden regardless of modifier
- interface can be use the extend keyword
- interface variables are assumed to be public static final

6. fejezet
- runtime exceptions = unchecked exceptions
- everithing that is not extend runtime exception is checked exception
- you have to deal with checked exceptions (handle or declare)
- catch not required if finally present
- catch superclass exception after subclass
	
OCP

Java Class Design

- a function overload is compile time polymorphism
- Java allow function with the same name as the class
- when overriding method return type can be subclass (covariant type)
- use @Override to not hide methods but override  them

- static variable == class variable
- static block will be invoked when the program init
- cannot override static method
- static method cannot use “this” keyword or “super”

- static method cannot acces insrance variable
- local inner class is in a code block; non-local inner class is in a class
- inner class accessibilty defined by the outer  class
- pass only final variable to local inner class

- ENUM has only private constructor
- interface extends other interface not implements
- class inheritance : is -a relation
- interface inheritance: is -like-a relation

- composition has-a-relation
- inner classes not loaded until referenced
- without <> (diamond operator) compiler treat as raw (Object class) type
- raw types bypass type check at compile time

- in generic subtyping does not work, use wildcards instead
- using wildcard you cant use methods that modify the object
- hascode should return the same hash if the equls method return true
- compareto method only good for one property, comparator class as many property as you want

----------------------------------------------------------------------------------------------------------------------------
Regular expressions
	The metacharacters supported by this API are: <([{\^-=$!|]})?*+.>
	There are two ways to force a metacharacter to be treated as an ordinary character:

		- precede the metacharacter with a backslash, or
		- enclose it within \Q (which starts the quote) and \E (which ends it).
	
Quantifiers: 
	Greedy quantifiers are considered "greedy" because they force the matcher to read in, or eat, the entire input string prior to attempting the first match.
	If the first match attempt (the entire input string) fails, the matcher backs off the input string by one character and tries again,  
	he reluctant quantifiers, however, take the opposite approach: They start at the beginning of the input string, then reluctantly eat one
	character at a time looking for a match. The last thing they try is the entire input string.
	Finally, the possessive quantifiers always eat the entire input string, trying once (and only once) for a match.

Boundary matchers

Annotation 

	Repeating annotations are supported as of the Java SE 8 release. 
	There are several methods available in the Reflection API that can be used to retrieve annotations. 
	It's specified by section 9.6.1 of the JLS. The annotation member types must be one of:
		- primitive
		- String
		- Class
		- an Enum
		- another Annotation
		- an array of any of the above
	Additional restriction : it has to be a compile-time constant. 

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

Java Streams

	Understand how Java Streams are used to handle input/output. 
		- InputStream (autoclosable -> can used with try-with-resource)
		- OutputStream  (autoclosable -> can used with try-with-resource)
		these are abstract classes. Implementation can be vary.

		There are buffered versions also.
		Buffered input streams read data from a memory area known as a buffer; the native input API is called only when the buffer is empty. 
		Similarly, buffered output streams write data to a buffer, and the native output API is called only when the buffer is full. 

		CharacterStream : The Java platform stores character values using Unicode conventions. Character stream I/O automatically translates 
		this internal format to and from the local character set. In Western locales, the local character set is usually an 8-bit superset of ASCII.

	Read and Write streams 
		Wrappers around Input / output Streams
		It often makes sense to write out a buffer at critical points, without waiting for it to fill. This is known as flushing the buffer. 

	Handle files 
		The methods for creating a new file enable you to specify an optional set of initial attributes for the file. For example, on a file system that supports the POSIX set of standards (such as UNIX), you can specify a file owner, group owner, or file permissions at the time the file is created. 

		The following StandardOpenOptions enums are supported:
			WRITE – Opens the file for write access.
			APPEND – Appends the new data to the end of the file. This option is used with the WRITE or CREATE options.
			TRUNCATE_EXISTING – Truncates the file to zero bytes. This option is used with the WRITE option.
			CREATE_NEW – Creates a new file and throws an exception if the file already exists.
			CREATE – Opens the file if it exists or creates a new file if it does not.
			DELETE_ON_CLOSE – Deletes the file when the stream is closed. This option is useful for temporary files.
			SPARSE – Hints that a newly created file will be sparse. This advanced option is honored on some file systems, 
				such as NTFS, where large files with data "gaps" can be stored in a more efficient manner where those empty gaps do not consume disk space.
			SYNC – Keeps the file (both content and metadata) synchronized with the underlying storage device.
			DSYNC – Keeps the file content synchronized with the underlying storage device.
			
		If you have a small-ish file and you would like to read its entire contents in one pass, you can use the readAllBytes(Path) or 
		readAllLines(Path, Charset) method. These methods take care of most of the work for you, such as opening and closing the stream, 
		but are not intended for handling large files. 

		You can use one of the write methods to write bytes, or lines, to a file. 

		In a single atomic operation, the createFile method checks for the existence of the file and creates that file with the specified 
		attributes, which makes the process more secure against malicious code. 

		Create - Delete - Read - Write (CRUD) 
		Change file permition

	Object serialization 
		So an object stream can contain a mixture of primitive and object values.
		If readObject() doesn't return the object type expected, attempting to cast it to the correct type may throw 
		a ClassNotFoundException. In this simple example, that can't happen, so we don't try to catch the exception. 
		Instead, we notify the compiler that we're aware of the issue by adding ClassNotFoundException to the main method's throws clause.   
		When you serialize an object, only the object's state will be saved, not the object's class file or methods. 
		How not to serialize any field in class?
		Ans: use transient keyword 

	Versioning of Serializable Objects 
		set a fixed serialVersionUID. (not doing it may cause  InvalidClassException )
		private static final long serialVersionUID = 3375159358757648792L;
		
	NIO files 
		The Java NIO Files class (java.nio.file.Files) provides several methods for manipulating files in the file system. 
		This Java NIO Files tutorial will cover the most commonly used of these methods. The Files class contains many methods, 
		so check the JavaDoc too, if you need a method that is not described here. The Files class just might have a method for it still.

		The java.nio.file.Files class works with java.nio.file.Path instances, so you need to understand the Path class before you can work with the Files class.

			- Files.exists()
			- Files.createDirectory()
			- Files.copy()
			- Overwriting Existing Files
			- Files.move()
			- Files.delete()
			- Files.walkFileTree()
			- Searching For Files
			- Deleting Directories Recursively
			- Additional Methods in the Files Class
			
	Java NIO vs. IO 
	
		IO				|	NIO
		----------------|------------------
		Stream oriented	|	Buffer oriented
		Blocking IO	Non |	blocking IO
						|	Selectors
							
		Java IO being stream oriented means that you read one or more bytes at a time, from a stream. What you do with the read bytes is up to you.
		They are not cached anywhere. Furthermore, you cannot move forth and back in the data in a stream. If you need to move forth and back in the 
		data read from a stream, you will need to cache it in a buffer first. 

		Java NIO's buffer oriented approach is slightly different. Data is read into a buffer from which it is later processed. You can move forth and 
		back in the buffer as you need to. This gives you a bit more flexibility during processing. However, you also need to check if the buffer contains 
		all the data you need in order to fully process it. And, you need to make sure that when reading more data into the buffer, you do not overwrite data 
		in the buffer you have not yet processed. 

		thread invokes a read() or write(), that thread is blocked until there is some data to read, or the data is fully written. The thread can do 
		nothing else in the meantime. 

		Java NIO's selectors allow a single thread to monitor multiple channels of input. 

NIO network programming 
	NIO allows you to manage multiple channels (network connections or files) using only a single (or few) threads, but the cost is that parsing 
	the data might be somewhat more complicated than when reading data from a blocking stream.

	If you need to manage thousands of open connections simultanously, which each only send a little data, for instance a chat server, implementing 
	the server in NIO is probably an advantage. Similarly, if you need to keep a lot of open connections to other computers, e.g. in a P2P network, 
	using a single thread to manage all of your outbound connections might be an advantage.

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

	Functional Decomposition
		is the process of taking a complex process and breaking it down into its smaller, simpler parts.

	Modularity
		separating the functionality of a program into independent, interchangeable modules

	Low cohasion
		cohesion refers to the degree to which the elements inside a module belong together.  Strength of relationship between the methods and data of a class.
		In a highly cohesive system, code readability and reusability is increased, while complexity is kept manageable. 
		https://en.wikipedia.org/wiki/Cohesion_(computer_science) 

	Coupling
		coupling is the degree of interdependence between software modules; a measure of how closely connected two routines or modules are.  
		Low coupling is often a sign of a well-structured computer system and a good design.

	Correctness
		for each input it produces the expected output

	Robustness
		is the ability of a computer system to cope with errors during execution[1][2] and cope with erroneous input

	Extensibility
		is a software engineering and systems design principle where the implementation takes future growth into consideration. 
		The term extensibility can also be         seen as a systemic measure of the ability to extend a system and the level of 
		effort required to implement the extension. 

	maintainability; 

	Reusability
		is the use of existing assets in some form within the software product development process; these assets are products and by-products 
		of the software     development life     cycle and include code, software components, test suites, designs and documentation. 
		The opposite concept of reusability is leverage, which modifies   existing assets as needed to meet   specific system requirements. 

	Fulnctionality
	
	Comptatibility
		Compatibility can refer to interoperability between any two products

	Portability

	Performance 

	Aggregation
		A "owns" B = Composition : B has no meaning or purpose in the system without A
		A "uses" B = Aggregation : B exists independently (conceptually) from A
	
	Association
		defines a relationship between classes of objects that allows one object instance to cause another to perform an action on its behalf. This relationship   is structural, because   it specifies that objects of one kind are connected to objects of another and does not represent behaviour.   "sending a message", "invoking a method"   or "calling a member function"

	Responsibility driven design:
		improves encapsulation by using the client–server model. It focuses on the contract by considering the actions that the object is responsible for
        and the information that the object shares. https://en.wikipedia.org/wiki/Responsibility-driven_design.  
		both the client and the server are classes or instances of classes.    
		focuses on the objects as behavioral abstractions which are characterized by their responsibilities

	Rule based design

	Data driven design
		With data-driven design the onus is on quantitative data – i.e. the insights you can derive from looking at numbers. 
		Therefore it’s a process of  developing or improving a product based on things you can measure – such as looking at your site’s analytics, 
		carrying out A/B testing or conducting surveys.
		
		
Value object:

	In computer science, a value object is a small object that represents a simple entity whose equality is not based on identity: 
	i.e. two value objects are equal when they have the same value, not necessarily being the same object. 

	Value objects should be immutable:[3] this is required for the implicit contract that two value objects created equal, 
	should remain equal. It is also useful for value objects to be immutable, as client code cannot put the value object in an invalid state 
	or introduce buggy behaviour after instantiation. 

	Java has no support for custom value types at the language level. 

	A class can be made immutable by declaring all attributes blank final,[13] and declaring all attributes to be of immutable type 
	(such as String, Integer, or any other type declared in accordance with these rules), not of mutable type such an ArrayList or even a Date. 
	They should also define equals and hashCode to compare values rather than references. 

	The obvious drawbacks of value objects are that the numbers of classes in the project might grow significantly and, as they’re usually immutable, 
	the number of created objects, too.


Principles of Packaging:

	Principles of package cohesion
		The Reuse-Release Equivalence Principle (REP)
			The basic idea of this principle is that packages must be separately released, 
			versioned, and tracked. In order to make use of a package in other code, we need to 
			be able to safely depend on that package. For that, we need to be able to choose 
			when and if to update to a newer version of the package.

		The Common-Reuse Principle (CRP)
			This principle suggests that we group classes into packages based on whether or not they are used/re-used together.
			If you depend on a package but only use a small part of it, you still depend on the entire package. If other parts 
			of the package change, you have to think about updating your dependency, even though the changes have no effect on your code.

		The Common-Closure Principle (CCP)
			This principle is essentially the Single Responsibility Principle (SRP) for packages. “Closed” is used here in the same sense as 
			it is in the Open-Closed Principle (OCP).When we need to change our code, it is best if we only have to change one package. 
			So, it makes sense to group classes together that have to change for similar reasons and to separate classes that have to 
			change for different reasons.

	Principles of package coupling
		Acyclic Dependencies Principle (ADP)
			In a development cycle with multiple developers, cooperation and integration needs to happen in small incremental releases. 
			The ADP states that there can be no cycles in the dependency structure, and that when an incremental release is made, the other 
			developers can adopt and build upon it.

		Stable-Dependencies Principle (SDP)
			Designs, by nature of the environments they are used in or by, are changing. Thus, package design needs to support change as 
			well. The SDP states that any packages one wants to be volatile should not be depended upon by a package that is difficult to change.

		Stable-Abstractions Principle (SAP)
			The SAP says that a stable package should also be abstract, so that its stability does not prevent it from being extended.
			It also states that an unstable package should be concrete, since its instability allows the concrete code within it to be easily changed.

	Package By Layer (PBL)
		This is a the first thing that developers do when the create an enterprise application in to split it to number of layers like DAO, SERVICE, VIEW etc.. 
		This gives nice separation of code when we use different frameworks at different layers. 

	Package By Feature (PBF)
		Package-by-feature uses packages to reflect the feature set. It places all items related to a single feature (and only that feature) into a single
		directory/package. 		This results in packages with high cohesion and high modularity, and with minimal coupling between packages. Items that work
		closely together are placed next to each other. They aren't spread out all over the application.
		This also increases coherence as a large percentage of a the dependencies of a class are located close to that class.	
			
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
               

			   
General testing
	
	Static vs dynamic testing
		Static testing and dynamic testing are important testing methods available for developers and testers in Software Development lifecycle. 
		These are software testing techniques which the organisation must choose carefully which to implement on the software application. 
		In order to get the most out of each type of testing, and choose the right tools for a given situation, it’s crucial to understand the benefits 
		and limitations of each type of testing.
		
	Static testing
		Static Testing is type of testing in which the code is not executed. It can be done manually or by a set of tools. This type of testing checks the code, 
		requirement documents and design documents and puts review comments on the work document. When the software is non –operational and inactive, we perform 
		security testing to analyse the software in non-runtime environment. With static testing, we try to find out the errors, code flaws and potentially malicious 
		code in the software application. It starts earlier in development life cycle and hence it is also called verification testing. Static testing can be done 
		on work documents like requirement specifications, design documents, source code, test plans, test scripts and test cases, web page content.
		
	The Static test techniques include:
		- Inspection: Here the main purpose is to find defects. Code walkthroughs are conducted by moderator. It is a formal type of review where a checklist is 
		prepared to review the work documents.
		- Walkthrough: In this type of technique a meeting is lead by author to explain the product. Participants can ask questions and a scribe is assigned to make notes.
		- Technical reviews: In this type of static testing a technical round of review is conducted to check if the code is made according to technical specifications 
			and standards. Generally the test plans, test strategy and test scripts are reviewed here.
		- Informal reviews: Static testing technique in which the document is reviewed informally and informal comments are provided.
	
	Dynamic testing
		Dynamic testing is done when the code is in operation mode. Dynamic testing is performed in runtime environment. When the code being executed is input 
		with a value, the result or the output of the code is checked and compared with the expected output. With this we can observe the functional behaviour 
		of the software, monitor the system memory, CPU response time, performance of the system. Dynamic testing is also known as validation testing , evaluating 
		the finished product. Dynamic testing is of two types: Functional Testing and Non functional testing.
		
	Types of Dynamic Testing techniques are as follows:
		- Unit Testing: Testing of individual modules by developers.. The source code is tested in it.
		- Integration Testing: Testing the interface between different modules then they are joined..
		- System Testing: Testing performed on the system as a whole.
		- Acceptance Testing: Testing done from user point of view at user’s end.
		
	However, both Static Testing and Dynamic Testing are important for the software application. There are number of strengths and weaknesses associated with both types 
	of testing which should be considered while implementing these testing on code.
	
	V-model
		- On the left-hand side of the V-model, we have activities that are not performed by the QA team.
		- On the right-hand side, we have some of them that are taken care of the Dev team, some by the testers and some by users.

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
		
High level concurency support
	
	Java.util.concurent: Small standardized framework. PArts: executor, queues, timing, synchronizers, collections,
		memory consistenci properties. Used as building blocks for creating concurent  classes or applications. 
		Expose low-level compare-and-swap hardware instructions.
		
	Executor framwork: Interface for define costum thread like subsystems. Executor service maages queues, scheduling tasks
		and shutdown. Multiple concrete executor classes. Task submission is decoupled from task execution policy.
		Shutting down via executor service interface (await termination, isShutdown, shutdown) Get executor through factory.
		
	Future pattern: Represent the result of an async computation. Methods for check is the computation is complate and retrive result.
		Cancellable, can be blocking.
		
	Completition Service: Decouples the production of async taks from the consumptions of the results. Producers submit tasks, 
		consumers take completed tasks and process their results.
		
	Lock / reentrant lock: Lock -> sync mechanism, more sophistacet then synchronized blocks. It is an interface -> has a framework
		reentrantlock -> (reentrant lock multiple time ) owned by the thread that successfully locked, but not unlocked yet. 
		Return imediatly if current thread already has the lock. Concrate implementation od lock interface. Fairness. 
		Lock interrupltly, ability to time out. Drawbacks -> try catch block
		
	timer and Timertask class: Provide help for controlling time - out based operations. Implementation make "best effort" to 
		detecttimeouts. Schedule tasks, timer tasks. Timer task should not be very long. Timer is a thread and can be assign 
		to timer task.
		
	Semaphore: MAintain all sets of permitions. For example limit concurent access to certain parts. Use try/finally to
		properly relesase semaphore.
	
	Phaser: Thread synchronization mechanism. You have to wait for threads to arrive before continue or start another set of tasks.
	
	Countdownlatch: Allows threads to wait for one or more threads before start processsing. Not reusable once count reach zero.
	
	Cyclic Barrier: Like countdodn latch but reusable calling reset().
	
	Fork-join framework: Done inmemory algorithms. Responsible to create new task object which can create subtask and wait to finish them. 
		Maintain pools and executor for tasks.
		
	Atomic variables: get/set that work like read/write on volatile variables. Atomic = threadsafe without synchronized keyword.
		Heavily use compare and swap, which is hardware supported.
		
	Concurent hashmap: implementaion od concurent Map. Simultaniously allow 16 thread to read/write without external sync. Very scalable.
	
	CopyOnWriteArrayList: Implement List interface. Copy list each tiome it is change. Expensive for large lists. Ok for few modification
		with many reads. Iterators use snapshot of the array. (not reflect change)
		
	ConcurentSkipListMap: Implement concurent navigational map. Elements sorted based on thir natural ordered keys. Allow fast search
		in an orderd sequence of elements. Guaranties O(logn) for most operations.
		
	BlockingQueue: Thread safe to insert or retrive elements from it. Block request of insert new lement when the queue is full, 
		or remove if empty. all with timeouts. Nice way to make producer-costumer pattern. 
		
Rest, restfull, soap

	REST (representational state transfer) Provide interoperability between computer systems aon the internet. Allows access and 
		manipulatetextural represnetation of resources (identified by url), using uniform, statless operations.
		HTTP verb: put, post, patch, get, delete. Rest api URI may specify version number -> guarantee backward compatibility.
		
	SOAP (Simple Object Access Protocol) Exchange structured information in computer networks. Introduce extensibility, neutrality and
		independence. Use XML format and relies on application layer protocols (HTTP, SMTP) 
		- Envelope: Defines structure and how to process it.
		- set encoding rules
		SOAP can be defeined by 3 conceptual components: Protocol - Data Encapsulation - Message sender and reciever
		Advantages: Suitable to use with any transport protocol, tunels easy through proxies and firewalls.
		Disadv: Verbose protocol, slow parsing xml.		
		
	RESTfull service 6 architectural constrains:
		- Client-SErver architecture: Separation of concerns -> improve portabality accross platforms and improve scalability
		- Statelessness: No client context stored on server side between requests. Itempotent.
		- Cachablility: Client can cash responses.
		- Layered system: Client cannot tell it is directly connected to the server.Intermed enforce securtiy
		- Code on demand: (optianal) Services can transfare executable code.
		- Uniform interface: Simplify and decouple architecture.
		* Richardson maturity modell
		
Java 8
	
	Lamdba expression syntac: Replace anonimous classes. 
		- coma separated list of formal parameters, endclosed is parenthesis (can omitt data type, and parenthesis if there only one parameter)
		- arrow token
		- body consist of a single expression or statement block
		- simple expression no need to return statemnt
		- multiple expression in codeblocks
		- return statement not an expression
		
	Method reference: Allows to reference constructor or methods without executing them, Similar to lambda. Reguire a target type that consist 
		of a compatible function interface. x -> method == class::method, replace lamdba cant pass argument.
		
	Porpus of a @functionalInterface: It will allow to declar only single method in interface. Complie time checking. To use into lambda have to
		contain only one method.
		
	Internal iteration: Instead of controlling the iteration, the client let it handle by library and only provide the code which must be executed
		for all/some of data elements.
	
	function as first class citizen: input / output, smaller code, more readable, better way to show intention.
	
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
	
	Time management technices: pomodoro, ToDo list, Book yout ime in a calendar
	
	Delegation: Not have to been done by who to delegated, Needs to be done.
	Assignment: Clear responsibility to who assigned. Who will eventualy do.
	
	Risk managemant, strategies: spike stories, proof of concept, return of investment.
	
	User stories: direct, timly, testable, acceptance criteria, foable, definition of ready.

	Priority for sprint e lement: product owner decide
		- prioritized by business value, tech dept % must be
	 
	Non- functional requirements: security, performance, capture in acceptance criteria
	
	TDD: red-green-refactor cycle
	
	Product DB debug: ask data, ask DB dump, error logs, memory dump, reproduce in dev environment
	
	Choosing 3rd party library: -documentation, open / licence, responsiveness of issues, bug track, how easy to use
	
	Estimation: tech spikes, investigation; T-shirt size for high level things.