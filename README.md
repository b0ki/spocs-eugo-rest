spocs
=====

## Usage

Get the code and install into local maven repo:

     $ git clone https://github.com/b0ki/spocs-eugo-rest.git
     $ cd spocs-eugo-rest
     $ mvn clean install

Include in a maven project:

     <dependency>
         <groupId>eu.spocs</groupId>
         <artifactId>spocs-client</artifactId>
         <version>0.1</version>
     </dependency>

Use in Java code:

     EugoService service = EugoServiceFactory.createEugoService();



