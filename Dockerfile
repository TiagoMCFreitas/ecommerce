
# Estágio de execução
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado do estágio de construção para o diretório de trabalho
COPY --from=build /app/target/*.jar app.jar

# Comando para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]