import { SplitedContainer } from "@/components/splited-container";
import {
    HoverCard,
    HoverCardContent,
    HoverCardTrigger,
} from "@/components/ui/hover-card";
import { getUserSession } from "@/lib/user-session";
import { FollowUnfollowButton } from "./follow-unfollow-button";

export type ProfileCardProps = {
    profile: string;
};

export async function ProfileCard({ profile }: ProfileCardProps) {
    const user = await getUserSession();

    return (
        <HoverCard>
            <HoverCardTrigger className="cursor-pointer">
                {profile}
            </HoverCardTrigger>
            <HoverCardContent className="w-sm">
                <SplitedContainer profile={profile}>
                    {profile === user.login ? (
                        <>{profile}</>
                    ) : (
                        <FollowUnfollowButton follower={user.login} followed={profile} />
                    )}
                </SplitedContainer>
            </HoverCardContent>
        </HoverCard>
    );
}
