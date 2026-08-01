set -a
source .env
set +a
mysql -u "$DB_USER" -p"$DB_PASSWORD" -e "CREATE DATABASE IF NOT EXISTS livrariaJava;"
mvn flyway:migrate
