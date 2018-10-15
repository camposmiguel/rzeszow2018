import { Module, MiddlewareConsumer } from '@nestjs/common';
import { UserController } from './user.controller';
import { UserService } from './user.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { User } from './user.entity';
import { AuthMiddleware } from '../middlewares/auth.middleware';

@Module({
  imports: [TypeOrmModule.forFeature([User])],
    providers: [UserService],
    controllers: [UserController],
})
export class UsersModule {
  configure(consumer: MiddlewareConsumer) {
		consumer.apply(AuthMiddleware).forRoutes(UserController);
	}
}
