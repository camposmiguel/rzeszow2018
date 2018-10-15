import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UsersModule } from './user/users.module';
import { AuthModule } from './auth/auth.module';
import { UserService } from './user/user.service';
import { AuthService } from './auth/auth.service';
import { UserController } from './user/user.controller';
import { ExerciseController } from './exercise/exercise.controller';
import { ExerciseService } from './exercise/exercise.service';
import { ExerciseModule } from './exercise/exercise.module';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root',
      password: '',
      database: 'duck_hunt_api',
      entities: [__dirname + '/**/*.entity{.ts,.js}'],
      synchronize: true,
      charset: 'UTF8_GENERAL_CI'
    }),
    UsersModule,
    AuthModule,
    ExerciseModule,
  ],
  controllers: [AppController, UserController, ExerciseController],
  providers: [AppService, UserService, AuthService, ExerciseService],
})
export class AppModule {}
