import { Module, MiddlewareConsumer } from '@nestjs/common';
import { Exercise } from './exercise.entity';
import { ExerciseService } from './exercise.service';
import { ExerciseController } from './exercise.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AuthMiddleware } from 'middlewares/auth.middleware';

@Module({
    imports: [TypeOrmModule.forFeature([Exercise])],
    providers: [ExerciseService],
    controllers: [ExerciseController],
})
export class ExerciseModule {
    configure(consumer: MiddlewareConsumer) {
		consumer.apply(AuthMiddleware).forRoutes(ExerciseController);
	}
}
