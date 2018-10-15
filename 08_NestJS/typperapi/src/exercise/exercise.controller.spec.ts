import { Test, TestingModule } from '@nestjs/testing';
import { ExerciseController } from './exercise.controller';

describe('Exercise Controller', () => {
  let module: TestingModule;
  beforeAll(async () => {
    module = await Test.createTestingModule({
      controllers: [ExerciseController],
    }).compile();
  });
  it('should be defined', () => {
    const controller: ExerciseController = module.get<ExerciseController>(ExerciseController);
    expect(controller).toBeDefined();
  });
});
