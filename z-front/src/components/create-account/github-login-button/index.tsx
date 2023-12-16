"use client";

import { Icons } from "@/components/icons";
import { Button } from "@/components/ui/button";
import { signIn } from "next-auth/react";

export function GithubLoginButton() {
    return (
        <div className="grid grid-cols-1 gap-6">
            <Button variant="outline" onClick={() => signIn("github")}>
                <Icons.gitHub className="mr-2 h-6 w-6" />
                Github
            </Button>
        </div>
    );
}
