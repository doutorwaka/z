"use client";

import { UserRound } from "lucide-react";
import { useSession } from "next-auth/react";
import Link from "next/link";

export function ProfileButton() {
    const { data: profile } = useSession();

    return (
        <Link
            href={`/profile/${profile?.user.login}`}
            className="flex gap-4 rounded-full p-4 hover:bg-menu-hover text-lg"
        >
            <div>
                <UserRound />
            </div>
            <div>Perfil</div>
        </Link>
    );
}
