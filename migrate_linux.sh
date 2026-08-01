set -a
source .env
set +a
mysql -u "$DB_USER" -p"$DB_PASSWORD" -e "DROP DATABASE IF EXISTS livrariaJava; CREATE DATABASE livrariaJava;"
mvn flyway:migrate
