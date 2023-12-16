import Image from "next/image";
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
} from "../ui/card";
import ZImage from "../../images/z.png";
import { GithubLoginButton } from "./github-login-button";

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
                <GithubLoginButton />
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
