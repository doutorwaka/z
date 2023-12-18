import { SplitedContainer } from "@/components/splited-container";
import { Button } from "@/components/ui/button";
import {
    HoverCard,
    HoverCardContent,
    HoverCardTrigger,
} from "@/components/ui/hover-card";
import { getUserSession } from "@/lib/user-session";

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
                        <Button
                            variant={"default"}
                            className="w-full rounded-full"
                        >
                            Seguir
                        </Button>
                    )}
                </SplitedContainer>
            </HoverCardContent>
        </HoverCard>
    );
}
