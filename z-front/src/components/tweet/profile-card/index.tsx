"use client";

import { SplitedContainer } from "@/components/splited-container";
import {
    HoverCard,
    HoverCardContent,
    HoverCardTrigger,
} from "@/components/ui/hover-card";
import { FollowUnfollowButton } from "./follow-unfollow-button";
import { useSession } from "next-auth/react";

export type ProfileCardProps = {
    profile: string;
};

export function ProfileCard({ profile }: ProfileCardProps) {
    const { data: session } = useSession();

    const userLogin = session?.user.login || "";

    return (
        <HoverCard>
            <HoverCardTrigger className="cursor-pointer">
                {profile}
            </HoverCardTrigger>
            <HoverCardContent className="w-sm">
                <SplitedContainer profile={profile}>
                    {profile === userLogin ? (
                        <>{profile}</>
                    ) : (
                        <FollowUnfollowButton
                            follower={userLogin}
                            followed={profile}
                        />
                    )}
                </SplitedContainer>
            </HoverCardContent>
        </HoverCard>
    );
}
