# stockDataGenerator

## purpose
  this project is test project for generating fake stock data.

## function
  it implements the order-driven market trading mechanism. In the initialization part it initialize 5 stock with some initial price and shares, and then it will randomly generate buy and sell orders for these 5 stocks, and output the prices after execute the order.

## deploy

this project is writen in java and managed by maven, so you need to have a jdk8 and maven installed. And then you can deploy it by following methods.

### method 1
 You can run the project with command "mvn spring-boot:run" when you enter the project's root directory.
### method 2
  Or you can run the command "mvn package" first to package the project, than run the command "java -jar target/stockDataGenerator-0.0.1-SNAPSHOT.jar" to start the project.
