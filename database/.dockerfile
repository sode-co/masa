FROM mcr.microsoft.com/mssql/server:2017-latest

COPY setup.sql setup.sql
COPY setup_database.sh setup_database.sh
COPY entrypoint.sh entrypoint.sh

RUN chmod +x setup_database.sh
RUN chmod +x entrypoint.sh

CMD /bin/bash ./entrypoint.sh