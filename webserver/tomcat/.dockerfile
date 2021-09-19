FROM tomcat:9.0.20

# tomcat-users.xml sets up user accounts for the Tomcat manager GUI
# and script access for Maven deployments

WORKDIR $CATALINA_HOME

ADD webserver/tomcat/tomcat-users.xml $CATALINA_HOME/conf/

RUN mkdir $CATALINA_HOME/webapps/masa

ADD masa_backend/target/masa $CATALINA_HOME/webapps/masa
# ADD tomcat/catalina.sh $CATALINA_HOME/bin/
ADD webserver/tomcat/run.sh $CATALINA_HOME/bin/run.sh
RUN chmod +x $CATALINA_HOME/bin/run.sh
ADD webserver/tomcat/context.xml /usr/local/tomcat/webapps/manager/META-INF/
# create mount point for volume with application

# add tomcat jpda debugging environmental variables
# ENV JPDA_OPTS="-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

EXPOSE 8080
CMD ["run.sh"]
