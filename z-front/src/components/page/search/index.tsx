"use client";

import { SplitedContainer } from "@/components/splited-container";
import { ProfileCard } from "@/components/tweet/profile-card";
import { Input } from "@/components/ui/input";
import { services } from "@/services";
import { ProfileDto } from "@/services/profile";
import { Search } from "lucide-react";
import { useState } from "react";

async function searchProfile(profile: string) {
    try {
        const { profiles } = await services.profile.search({ profile });
        return profiles;
    } catch (error) {
        return [];
    }
}

export function PageSearch() {
    const [profiles, setProfiles] = useState<ProfileDto[]>([]);

    function generateProfileCads(profiles: ProfileDto[]) {
        return profiles.map((profile) => {
            return (
                <SplitedContainer key={profile.id} profile={profile.login}>
                    <ProfileCard profile={profile.login} key={profile.id} />
                </SplitedContainer>
            );
        });
    }

    return (
        <div>
            <div className="flex w-full items-center py-4">
                <Search className="text-muted-foreground relative left-10 top-3 transform -translate-y-1/2" />
                <Input
                    placeholder="Busque alguém para seguir..."
                    className="pl-12 rounded-full font-light text-lg"
                />
            </div>
            {generateProfileCads(profiles)}
        </div>
    );
}
