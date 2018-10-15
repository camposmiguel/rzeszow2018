import { Middleware, NestMiddleware, Injectable } from '@nestjs/common';

import * as jwt from 'jsonwebtoken';

@Injectable()
export class CorsMiddleware implements NestMiddleware {

    constructor() {}

    resolve() {

        return(req, res, next) => {

            const allowAll = true;
            const allowedOrigins = ['*', 'http://localhost:3000', 'http://localhost:4200', 'http://www.resucitoapp.com'];
            if (allowAll || allowedOrigins.indexOf(req.header('Origin')) > -1) {
                if (allowAll) {
                    res.setHeader('Access-Control-Allow-Origin', '*');
                  } else {
                    res.setHeader('Access-Control-Allow-Origin', req.header('Origin'));
                  }
                res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
                res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
                res.setHeader('Access-Control-Allow-Credentials', true);
            } else {
                return res.status(401).json('Origen no permitido');
            }

            next();
        };
    }
}