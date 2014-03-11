JAVA=/usr/lib/jvm/java-1.7.0-openjdk-amd64/bin/java
LIB=./lib/
CLASSPATH=$(find $LIB -name '*.jar' | tr '\n' ':')
export CLASSPATH=./bin/:$CLASSPATH
echo $CLASSPATH
XML=./xml/example1.xml

$JAVA xml.XmlParser $XML