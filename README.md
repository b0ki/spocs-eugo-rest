spocs
=====

## Usage

Get the code and install into local maven repo:

     $ git clone git://github.com/b0ki/spocs.git
     $ cd spocs
     $ mvn clean install

Include in a maven project:

     <dependency>
         <groupId>eu.spocs</groupId>
         <artifactId>spocs-client</artifactId>
         <version>0.1-SNAPSHOT</version>
     </dependency>

Use in Java code:

     EugoService service = EugoServiceFactory.createEugoService();



