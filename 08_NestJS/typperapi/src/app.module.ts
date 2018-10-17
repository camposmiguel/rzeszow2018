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
import { LevelController } from './level/level.controller';
import { LevelService } from './level/level.service';
import { LevelModule } from './level/level.module';
import { BattleController } from './battle/battle.controller';
import { BattleService } from './battle/battle.service';
import { BattleModule } from './battle/battle.module';

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
    LevelModule,
    BattleModule,
  ],
  controllers: [AppController, UserController, ExerciseController, LevelController, BattleController],
  providers: [AppService, UserService, AuthService, ExerciseService, LevelService, BattleService],
})
export class AppModule {}
