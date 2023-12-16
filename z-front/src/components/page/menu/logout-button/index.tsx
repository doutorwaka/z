"use client";

import { LogOut } from "lucide-react";
import { signOut } from "next-auth/react";

export function LogoutButton() {
    return (
        <button
            className="flex gap-4 rounded-full p-4 hover:bg-menu-hover text-lg"
            onClick={() => signOut()}
        >
            <div>
                <LogOut />
            </div>
            <div>Sair</div>
        </button>
    );
}
