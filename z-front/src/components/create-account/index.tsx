"use client";

import Image from "next/image";
import { Icons } from "../icons";
import { Button } from "../ui/button";
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
} from "../ui/card";
import ZImage from "../../images/z.png";

export function CreateAccount() {
    return (
        <Card className="w-full h-max p-2 border-muted-foreground">
            <CardHeader className="space-y-1">
                <CardTitle className="text-2xl uppercase">Bem vindo</CardTitle>
                <CardDescription>
                    Use sua conta do Github para entrar
                </CardDescription>
            </CardHeader>
            <CardContent className="grid gap-4">
                <div className="grid grid-cols-1 gap-6">
                    <Button variant="outline">
                        <Icons.gitHub className="mr-2 h-6 w-6" />
                        Github
                    </Button>
                </div>
            </CardContent>
            <CardFooter>
                <Image
                    src={ZImage}
                    alt="Bem vindo ao Z!"
                    className="m-auto"
                    width={375}
                    height={375}
                />
            </CardFooter>
        </Card>
    );
}
