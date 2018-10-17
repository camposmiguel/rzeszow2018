import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule, {
    logger: false,
  });
  app.enableCors();
  app.setGlobalPrefix('typperapi');
  await app.listen(3001);
}
bootstrap();
